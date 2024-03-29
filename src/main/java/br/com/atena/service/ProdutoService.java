package br.com.atena.service;

import br.com.atena.commons.compartilhado.DefaultService;
import br.com.atena.commons.compartilhado.S3Service;
import br.com.atena.commons.utils.ImageService;
import br.com.atena.exceptions.FileException;
import br.com.atena.exceptions.ObjectNotFoundException;
import br.com.atena.model.CategoriaModel;
import br.com.atena.model.ProdutoModel;
import br.com.atena.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@Service
public class ProdutoService extends DefaultService<ProdutoModel, ProdutoRepository> {
    @Autowired
    private S3Service s3Service;

    @Autowired
    private ImageService imageService;

    public List<ProdutoModel> findByCategoria(List<CategoriaModel> categorias) {
        return getRepository().findBycategoriasIn(categorias);
    }

    public Page<List<ProdutoModel>> findAllByFilter(String nome, String codBarras, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return getRepository().findByNomeOrCodBarras(nome, codBarras, pageRequest);
    }

    public URI uploadProfilePicture(MultipartFile file, Long id) {
        ProdutoModel produto = getRepository().findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Produto com o id: " + id + "não encontrado, caso o erro persista entre em contato com o responsável."));
        try {
            BufferedImage jpgImage = jpgImage = imageService.getJpgImageFromFile(file);
            jpgImage = imageService.cropSquare(jpgImage);
            jpgImage = imageService.resize(jpgImage);
            String nome = "prod" + produto.getNome() + produto.getId();
            produto.setImagem(s3Service.uploadFile(imageService.getInputStream(jpgImage), nome, "image"));
            getRepository().save(produto);

        } catch (IOException e) {
            new FileException("Erro ao redimensionar a imagem, se o problema persistir entre em contato com o setor resposável.");
        }
        return produto.getImagem();
    }
}

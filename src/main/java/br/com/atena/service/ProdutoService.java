package br.com.atena.service;

import br.com.atena.commons.DefaultService;
import br.com.atena.commons.S3Service;
import br.com.atena.exceptions.ObjectNotFoundException;
import br.com.atena.model.CategoriaModel;
import br.com.atena.model.ProdutoModel;
import br.com.atena.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@Service
public class ProdutoService extends DefaultService<ProdutoModel, ProdutoRepository> {
    @Autowired
    private S3Service s3Service;

    public List<ProdutoModel> findByCategoria(List<CategoriaModel> categorias){
        return getRepository().findBycategoriasIn(categorias);
    }

    public URI uploadProfilePicture(MultipartFile file, Long id) {
        ProdutoModel produto = getRepository().findById(id).orElseThrow(
                ()->new ObjectNotFoundException("Produto com o id: "+ id+ "não encontrado, caso o erro persista entre em contato com o responsável."));
        produto.setImagem(s3Service.uploadFile(file));
        getRepository().save(produto);
        return produto.getImagem();
    }
}

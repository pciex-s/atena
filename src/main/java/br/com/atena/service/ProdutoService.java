package br.com.atena.service;

import br.com.atena.commons.DefaultService;
import br.com.atena.model.CategoriaModel;
import br.com.atena.model.ProdutoModel;
import br.com.atena.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService extends DefaultService<ProdutoModel, ProdutoRepository> {
    public List<ProdutoModel> findByCategoria(List<CategoriaModel> categorias){
        return getRepository().findBycategoriasIn(categorias);
    }
}

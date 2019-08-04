package br.com.atena.service;

import br.com.atena.commons.BaseService;
import br.com.atena.model.ProdutoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements BaseService<ProdutoModel> {
    @Override
    public ProdutoModel save(ProdutoModel produtoModel) {
        return null;
    }

    @Override
    public List<ProdutoModel> findAll() {
        return null;
    }

    @Override
    public ProdutoModel findById(Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

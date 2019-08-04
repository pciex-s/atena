package br.com.atena.service;

import br.com.atena.commons.BaseService;
import br.com.atena.model.ProdutoModel;
import br.com.atena.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements BaseService<ProdutoModel> {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public ProdutoModel save(ProdutoModel produtoModel) {
        return null;
    }

    @Override
    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public ProdutoModel findById(Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void atualizar(Long id, ProdutoModel produtoModel) {

    }
}

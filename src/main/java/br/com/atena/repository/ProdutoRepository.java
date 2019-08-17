package br.com.atena.repository;

import br.com.atena.commons.compartilhado.BaseRepository;
import br.com.atena.model.CategoriaModel;
import br.com.atena.model.ProdutoModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends BaseRepository<ProdutoModel, Long> {
    List<ProdutoModel> findBycategoriasIn(List<CategoriaModel> categorias);
}

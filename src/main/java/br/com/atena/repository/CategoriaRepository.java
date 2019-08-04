package br.com.atena.repository;

import br.com.atena.commons.BaseRepository;
import br.com.atena.model.CategoriaModel;
import br.com.atena.model.ProdutoModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends BaseRepository<CategoriaModel, Long> {
}

package br.com.atena.repository;

import br.com.atena.commons.compartilhado.BaseRepository;
import br.com.atena.model.CategoriaModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends BaseRepository<CategoriaModel, Long> {
}

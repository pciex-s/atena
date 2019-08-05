package br.com.atena.repository;

import br.com.atena.commons.BaseRepository;
import br.com.atena.model.EnderecoModel;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends BaseRepository<EnderecoModel, Long> {
}

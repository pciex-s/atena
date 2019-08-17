package br.com.atena.repository;

import br.com.atena.commons.compartilhado.BaseRepository;
import br.com.atena.model.ClienteModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<ClienteModel, Long> {
}

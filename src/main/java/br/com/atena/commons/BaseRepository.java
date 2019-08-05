package br.com.atena.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;

/**
 * @param <Classe> Recebe a classe entidade que o JPA repository irá implementar
 * @param <Id>     Recebe o o tipo do ID para mandar para o JPA
 *                 <p>
 *                 Esta interface é um repositório base, onde o metodo delete é usado por meio da query abaixo com JPQL
 * @Author Rafael Castro
 */

@NoRepositoryBean
public interface BaseRepository<Classe extends Object, Id extends Serializable> extends JpaRepository<Classe, Id> {

    @Modifying
    @Transactional
    @Query("update #{#entityName} set status = 0, data_atualizacao = sysdate where id = ?1")
    public void delete(Long id);

    @Modifying
    @Transactional
    @Query("update #{#entityName} set status = 0, data_atualizacao = sysdate where id = ?1")
    public void delete(Classe entidade);

}

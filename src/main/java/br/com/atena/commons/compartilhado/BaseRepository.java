package br.com.atena.commons.compartilhado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * @param <Classe> Recebe a classe entidade que o JPA repository irá implementar
 * @param <Id>     Recebe o o tipo do ID para mandar para o JPA
 *                 <p>
 *                 Esta interface é um repositório base, onde o metodo delete é usado por meio da query abaixo com JPQL
 * @Author Rafael Castro
 */

@NoRepositoryBean
public interface BaseRepository<Classe extends BaseEntity<Long>, Id extends Serializable> extends JpaRepository<Classe, Id> {

    @Modifying
    @Transactional
    @Query("update #{#entityName} set exclusao = true, dataAtualizacao = sysdate where id = ?1")
    public void delete(Long id);

    @Modifying
    @Transactional
    @Query("update #{#entityName} set exclusao = true, dataAtualizacao = sysdate where id = ?1")
    public void delete(Classe entidade);

}

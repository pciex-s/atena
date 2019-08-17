package br.com.atena.commons.compartilhado;

import org.springframework.data.domain.Page;


/**
 * @param <T> Recebe a entidade para o service retornar e cadastrar no banco de dados
 * @Author Rafael Castro
 */
public interface BaseService<T extends BaseEntity<Long>> {

    public T save(T t);

    public Page<T> findAll(String nome, Integer page, Integer linesPerPage, String orderBy, String direction);

    public T findById(Long id) throws Exception;

    public void delete(Long id);

    public void atualizar(Long id, T t);
}
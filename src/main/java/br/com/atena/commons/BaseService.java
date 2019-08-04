package br.com.atena.commons;

import java.util.List;


/**
 * @param <T> Recebe a entidade para o service retornar e cadastrar no banco de dados
 * @Author Rafael Castro
 */
public interface BaseService<T extends Object> {
    public T save(T t);

    public List<T> findAll();

    public T findById(Long id) throws Exception;

    public void delete(Long id);
}
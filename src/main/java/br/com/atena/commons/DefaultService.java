package br.com.atena.commons;

import br.com.atena.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

public class DefaultService<T extends Object, R extends BaseRepository<T, Long>> implements BaseService<T> {
    @Autowired
    private R repo;

    @Override
    public T save(T t) {
        return repo.save(t);
    }

    @Override
    public Page<T> findAll(String nome, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    @Override
    public T findById(Long id) throws Exception {
        return repo.findById(id).orElseThrow(
                ()->new ObjectNotFoundException("Objeto com o id: "+id+" não encontrado"));
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }

    @Override
    public void atualizar(Long id, T t) {
        repo.save(t);
    }

    public R getRepository(){
        return repo;
    }
}

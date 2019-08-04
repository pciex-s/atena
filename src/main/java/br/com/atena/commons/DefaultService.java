package br.com.atena.commons;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultService<T extends Object, R extends BaseRepository<T, Long>> implements BaseService<T> {
    @Autowired
    private R repo;

    @Override
    public T save(T t) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return repo.findAll();
    }

    @Override
    public T findById(Long id) throws Exception {
        return repo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }

    @Override
    public void atualizar(Long id, T t) {
        
    }

    public R getRepository(){
        return repo;
    }
}

package br.com.atena.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class DefaultController<T extends Object, R extends BaseRepository<T, Long>, Service extends DefaultService<T, R>> {
    @Autowired
    private Service s;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<T>>todos(){
        return ResponseEntity.ok(s.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<T> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(s.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<T> save(@RequestBody T t){
        T model = s.save(t);
        return ResponseEntity.ok(model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        s.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody T model , @PathVariable Long id) throws Exception {
        s.atualizar(id, model);
        return ResponseEntity.noContent().build();
    }
}

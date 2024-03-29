package br.com.atena.commons.compartilhado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class DefaultController<T extends BaseEntity<Long>, R extends BaseRepository<T, Long>, Service extends DefaultService<T, R>> {
    @Autowired
    private Service s;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<T>> todos(@RequestParam(value = "nome", defaultValue = "") String nome,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
                                         @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                                         @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        return ResponseEntity.ok(s.findAll(nome, page, linesPerPage, orderBy, direction));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<T> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(s.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<T> save(@RequestBody T t) {
        T model = s.save(t);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(model.getId())
                .toUri();
        return ResponseEntity.created(uri).body(model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        s.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody T model, @PathVariable Long id) throws Exception {
        s.atualizar(id, model);
        return ResponseEntity.noContent().build();
    }

    public Service getService() {
        return s;
    }
}

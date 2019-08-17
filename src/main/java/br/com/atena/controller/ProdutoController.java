package br.com.atena.controller;

import br.com.atena.commons.compartilhado.DefaultController;
import br.com.atena.model.ProdutoModel;
import br.com.atena.repository.ProdutoRepository;
import br.com.atena.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController extends DefaultController<ProdutoModel, ProdutoRepository, ProdutoService> {

    @RequestMapping(value = "/picture/{idProduto}", method = RequestMethod.POST)
    public ResponseEntity<Void> insertPicture(@RequestParam(name = "file") MultipartFile file, @PathVariable("idProduto")Long id) {
        URI uri = getService().uploadProfilePicture(file, id);
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/filter",method = RequestMethod.GET)
    public ResponseEntity<Page<List<ProdutoModel>>> filter(@RequestParam(value = "nome", defaultValue = "") String nome,
                                                          @RequestParam(value = "codBarras", defaultValue = "") String codBarras,
                                                          @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                          @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
                                                          @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                                                          @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        return ResponseEntity.ok(getService().findAllByFilter(nome,codBarras, page, linesPerPage, orderBy, direction));
    }
}

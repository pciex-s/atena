package br.com.atena.controller;

import br.com.atena.commons.DefaultController;
import br.com.atena.model.CategoriaModel;
import br.com.atena.model.ProdutoModel;
import br.com.atena.repository.ProdutoRepository;
import br.com.atena.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController extends DefaultController<ProdutoModel, ProdutoRepository, ProdutoService> {
    @RequestMapping(value = "/categoria")
    public ResponseEntity<List<ProdutoModel>> findProdutoByCategoria(){
        return ResponseEntity.ok(getService().findByCategoria(Arrays.asList(new CategoriaModel())));
    }
}

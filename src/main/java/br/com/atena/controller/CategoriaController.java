package br.com.atena.controller;

import br.com.atena.model.CategoriaModel;
import br.com.atena.model.ProdutoModel;
import br.com.atena.service.CategoriaService;
import br.com.atena.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaModel>> findAll() {
        return ResponseEntity.ok(categoriaService.findAll());
    }
}

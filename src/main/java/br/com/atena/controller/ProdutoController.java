package br.com.atena.controller;

import br.com.atena.commons.DefaultController;
import br.com.atena.model.ProdutoModel;
import br.com.atena.repository.ProdutoRepository;
import br.com.atena.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController extends DefaultController<ProdutoModel, ProdutoRepository, ProdutoService> {

    @RequestMapping(value = "/picture/{idProduto}", method = RequestMethod.POST)
    public ResponseEntity<Void> insertPicture(@RequestParam(name = "file") MultipartFile file, @PathVariable("idProduto")Long id) {
        URI uri = getService().uploadProfilePicture(file, id);
        return ResponseEntity.created(uri).build();
    }
}

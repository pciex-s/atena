package br.com.atena.controller;

import br.com.atena.commons.DefaultController;
import br.com.atena.model.ProdutoModel;
import br.com.atena.repository.ProdutoRepository;
import br.com.atena.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController extends DefaultController<ProdutoModel, ProdutoRepository, ProdutoService> {

    @RequestMapping(value = "/picture", method = RequestMethod.POST)
    public ResponseEntity<Void> insertPicture(@RequestParam(name = "file") MultipartFile file) {
        URI uri = getService().uploadProfilePicture(file);
        return ResponseEntity.created(uri).build();
    }
}

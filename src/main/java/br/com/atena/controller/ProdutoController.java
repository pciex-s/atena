package br.com.atena.controller;

import br.com.atena.commons.DefaultController;
import br.com.atena.model.ProdutoModel;
import br.com.atena.repository.ProdutoRepository;
import br.com.atena.service.ProdutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController extends DefaultController<ProdutoModel, ProdutoRepository, ProdutoService> {
}

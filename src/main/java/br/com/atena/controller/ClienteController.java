package br.com.atena.controller;

import br.com.atena.commons.DefaultController;
import br.com.atena.model.CategoriaModel;
import br.com.atena.repository.CategoriaRepository;
import br.com.atena.service.CategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController extends DefaultController<CategoriaModel, CategoriaRepository, CategoriaService> {

}

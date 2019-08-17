package br.com.atena.controller;

import br.com.atena.commons.compartilhado.DefaultController;
import br.com.atena.model.ClienteModel;
import br.com.atena.repository.ClienteRepository;
import br.com.atena.service.ClienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends DefaultController<ClienteModel, ClienteRepository, ClienteService> {

}

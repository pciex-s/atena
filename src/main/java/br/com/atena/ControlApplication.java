package br.com.atena;

import br.com.atena.model.CategoriaModel;
import br.com.atena.model.ProdutoModel;
import br.com.atena.model.enuns.StatusProduto;
import br.com.atena.repository.CategoriaRepository;
import br.com.atena.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ControlApplication implements CommandLineRunner {
	@Autowired
	private ProdutoRepository pRepo;

	@Autowired
	private CategoriaRepository cRepo;

	public static void main(String[] args) {
		SpringApplication.run(ControlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CategoriaModel c1 = new CategoriaModel(null, "Alimentação", null);
		ProdutoModel p1 = new ProdutoModel(null, "Pão", 10.0, 10.0, "1111111",1	, StatusProduto.ESTOQUE,Arrays.asList(c1), null);
		cRepo.save(c1);
		pRepo.save(p1);
	}
}

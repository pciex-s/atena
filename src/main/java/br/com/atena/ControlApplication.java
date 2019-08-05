package br.com.atena;

import br.com.atena.model.CategoriaModel;
import br.com.atena.model.ClienteModel;
import br.com.atena.model.EnderecoModel;
import br.com.atena.model.ProdutoModel;
import br.com.atena.model.enuns.Status;
import br.com.atena.model.enuns.StatusProduto;
import br.com.atena.repository.CategoriaRepository;
import br.com.atena.repository.ClienteRepository;
import br.com.atena.repository.EnderecoRepository;
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

	@Autowired
	private ClienteRepository cliRepo;

	@Autowired
	private EnderecoRepository endRepo;

	public static void main(String[] args) {
		SpringApplication.run(ControlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EnderecoModel e1 = new EnderecoModel(null, "55920000", "Rua Eliud falcão", "", "Centro", "Itambé", "PE", Status.ATIVO);
		ClienteModel cli1 = new ClienteModel(null, "Rafael", "31321123213", Arrays.asList(e1), Status.ATIVO);
		CategoriaModel c1 = new CategoriaModel(null, "Alimentação", null, Status.ATIVO);
		ProdutoModel p1 = new ProdutoModel(null, "Pão", 10.0, 10.0, "1111111",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, null);
		ProdutoModel p2 = new ProdutoModel(null, "Pão", 10.0, 10.0, "1111111",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, null);
		ProdutoModel p3 = new ProdutoModel(null, "Pão", 10.0, 10.0, "1111111",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, null);
		ProdutoModel p4 = new ProdutoModel(null, "Pão", 10.0, 10.0, "1111111",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, null);
		ProdutoModel p5 = new ProdutoModel(null, "Pão", 10.0, 10.0, "1111111",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, null);
		ProdutoModel p6 = new ProdutoModel(null, "Pão", 10.0, 10.0, "1111111",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, null);
		ProdutoModel p7 = new ProdutoModel(null, "Pão", 10.0, 10.0, "1111111",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, null);
		endRepo.save(e1);
		cRepo.save(c1);
		pRepo.saveAll(Arrays.asList(p1,p2,p3,p4, p5,p6,p7));
		cliRepo.save(cli1);
	}
}

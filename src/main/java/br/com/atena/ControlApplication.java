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
		EnderecoModel e1 = new EnderecoModel("55920000", "Rua Eliud falcão", "", "Centro", "Itambé", "PE");
		ClienteModel cli1 = new ClienteModel( "Rafael", "31321123213", Arrays.asList(e1), false);
		CategoriaModel c1 = new CategoriaModel("Alimentação");
		ProdutoModel p1 = new ProdutoModel( "Pão", 10.0, 10.0, "123456789123456789",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, false );
		ProdutoModel p2 = new ProdutoModel( "Pão", 10.0, 10.0, "123456789123456789",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, false);
		ProdutoModel p3 = new ProdutoModel( "Pão", 10.0, 10.0, "123456789123456789",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null , false);
		ProdutoModel p4 = new ProdutoModel( "Pão", 10.0, 10.0, "123456789123456789",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null ,false);
		ProdutoModel p5 = new ProdutoModel( "Pão", 10.0, 10.0, "123456789123456789",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null ,false);
		ProdutoModel p6 = new ProdutoModel( "Pão", 10.0, 10.0, "123456789123456789",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null ,false);
		ProdutoModel p7 = new ProdutoModel( "Pão", 10.0, 10.0, "123456789123456789",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, false);
		ProdutoModel p8 = new ProdutoModel( "Pão", 10.0, 10.0, "123456789123456789",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, false);
		ProdutoModel p9 = new ProdutoModel( "Pão", 10.0, 10.0, "123456789123456789",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, false);
		ProdutoModel p10 = new ProdutoModel( "Pão", 10.0, 10.0, "123456789123456789",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, false);
		ProdutoModel p11 = new ProdutoModel( "Pão", 10.0, 10.0, "123456789123456789",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, false);
		ProdutoModel p12 = new ProdutoModel( "Pão", 10.0, 10.0, "123456789123456789",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, false);
		ProdutoModel p13 = new ProdutoModel( "Pão", 10.0, 10.0, "123456789123456789",1	, 10.0,StatusProduto.ESTOQUE,Arrays.asList(c1),null, false);
		endRepo.save(e1);
		cRepo.save(c1);
		pRepo.saveAll(Arrays.asList(p1,p2,p3,p4, p5,p6,p7,p8,p9,p10,p11,p12,p13));
		cliRepo.save(cli1);
	}
}

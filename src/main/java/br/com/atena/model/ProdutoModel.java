package br.com.atena.model;

import br.com.atena.model.enuns.StatusProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private Double preco;
    private Double desconto;
    private String codBarras;
    private Integer qntEstoque;
    @Enumerated(EnumType.ORDINAL)
    private StatusProduto status;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<CategoriaModel> categoria;
}

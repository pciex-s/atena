package br.com.atena.model;

import br.com.atena.model.enuns.StatusProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
    private Double desconto;
    private String codBarras;
    private Integer qntEstoque;
    private Double precoUnitario;
    @Enumerated(EnumType.ORDINAL)
    private StatusProduto status;
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<CategoriaModel> categorias = new ArrayList<>();
    @Lob
    private Byte[] imagem;
    @Column(name = "DATA_ATUALIZACAO")
    private LocalDate dataAtualizacao;
}

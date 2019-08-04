package br.com.atena.model;

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
    private Long preco;
    private Long desconto;
    private String codBarras;
    @ManyToMany
    private List<CategoriaModel> categoria;
}

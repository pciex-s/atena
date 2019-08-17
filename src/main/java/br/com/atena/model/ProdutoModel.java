package br.com.atena.model;

import br.com.atena.commons.compartilhado.BaseEntity;
import br.com.atena.model.enuns.StatusProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoModel extends BaseEntity<Long> {
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
    private URI imagem;
}

package br.com.atena.model;

import br.com.atena.commons.compartilhado.BaseEntity;
import br.com.atena.model.enuns.StatusProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "exclusao = false")
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
    private List<CategoriaModel> categorias;
    private URI imagem;
    private boolean exclusao;
}

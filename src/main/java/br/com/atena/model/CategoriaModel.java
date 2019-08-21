package br.com.atena.model;

import br.com.atena.commons.compartilhado.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaModel extends BaseEntity<Long> {
    private String nome;
}

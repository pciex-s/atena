package br.com.atena.model;

import br.com.atena.commons.compartilhado.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoModel extends BaseEntity<Long> {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}

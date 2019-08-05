package br.com.atena.model;

import br.com.atena.model.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
}

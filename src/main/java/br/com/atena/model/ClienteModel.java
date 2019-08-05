package br.com.atena.model;

import br.com.atena.model.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpfOuCnpj;
    @OneToMany
    private List<EnderecoModel> enderecos;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
}

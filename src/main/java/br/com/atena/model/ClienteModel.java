package br.com.atena.model;

import br.com.atena.model.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Where(clause = "status = 1")
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

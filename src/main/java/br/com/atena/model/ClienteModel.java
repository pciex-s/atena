package br.com.atena.model;

import br.com.atena.commons.compartilhado.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Where(clause = "exclusao = false")
public class ClienteModel extends BaseEntity<Long> {
    private String nome;
    private String cpfOuCnpj;
    @OneToMany
    private List<EnderecoModel> enderecos;
    private boolean exclusao;
}

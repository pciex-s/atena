package br.com.atena.model;

import br.com.atena.model.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "DATA_ATUALIZACAO")
    private LocalDate dataAtualizacao;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
}

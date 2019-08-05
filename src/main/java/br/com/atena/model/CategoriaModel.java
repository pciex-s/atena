package br.com.atena.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "categoria")
@Data
@NoArgsConstructor
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "DATA_ATUALIZACAO")
    private LocalDate dataAtualizacao;

    public CategoriaModel(Long id, String nome, LocalDate dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.dataAtualizacao = dataAtualizacao;
    }
}

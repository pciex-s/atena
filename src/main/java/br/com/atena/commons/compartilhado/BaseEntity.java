package br.com.atena.commons.compartilhado;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Where;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@Where(clause = "exclusao = false")
public class BaseEntity<T extends Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public T id;
    public LocalDateTime dataAtualizacao;
    public LocalDateTime dataCriacao;
    public Boolean exclusao;
}

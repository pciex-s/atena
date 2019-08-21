package br.com.atena.repository;

import br.com.atena.commons.compartilhado.BaseRepository;
import br.com.atena.model.CategoriaModel;
import br.com.atena.model.ProdutoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends BaseRepository<ProdutoModel, Long> {
    List<ProdutoModel> findBycategoriasIn(List<CategoriaModel> categorias);

    @Query("SELECT p FROM produto p WHERE (:nome is null or p.nome = :nome) AND (:codBarras is null or p.nome = :codBarras) ")
    Page<List<ProdutoModel>> findByNomeOrCodBarras(@Param("nome") String nome, @Param("codBarras") String codBarras, Pageable page);
}

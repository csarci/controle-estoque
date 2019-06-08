package br.com.gm5.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gm5.estoque.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	@Query(value = "SELECT * FROM Produto p WHERE p.loja_id = :idLoja", nativeQuery=true)
	List<Produto> buscaByLojaId(@Param("idLoja") long idLoja);
}

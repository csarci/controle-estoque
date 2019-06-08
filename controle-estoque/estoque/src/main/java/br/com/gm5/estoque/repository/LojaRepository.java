package br.com.gm5.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gm5.estoque.model.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long>{

}

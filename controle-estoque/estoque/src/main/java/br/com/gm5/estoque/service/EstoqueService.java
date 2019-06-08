package br.com.gm5.estoque.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gm5.estoque.model.Loja;
import br.com.gm5.estoque.model.Produto;
import br.com.gm5.estoque.repository.LojaRepository;
import br.com.gm5.estoque.repository.ProdutoRepository;

@Service
public class EstoqueService {
	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Loja> findAllLojas() {
		return lojaRepository.findAll();
	}
	
	public List<Produto> findAllProdutos(){
		return produtoRepository.findAll();
	}
	
	public Loja buscaLojaById(Long id) {
		ArrayList <Long> temp = new ArrayList<>();
		temp.add(id);
		
		Loja loja = lojaRepository.findAllById(temp).get(0);
		
		return loja;
	}
	
	public List<Produto> buscaProdutosByLojaId(Long id) {
		return produtoRepository.buscaByLojaId(id);
	}
	
	public Loja salvaLoja(Loja loja) {
		return lojaRepository.saveAndFlush(loja);
	}
	
	public Produto salvaProduto(Produto prod) {
		return produtoRepository.saveAndFlush(prod);
	}
	
	public void deletarLoja(Long id) {
		lojaRepository.deleteById(id);
	}
	
	public void deletarProduto(Long id) {
		produtoRepository.deleteById(id);
	}

	public Produto buscaProdutoById(Long id) {
		ArrayList <Long> temp = new ArrayList<>();
		temp.add(id);
		
		Produto produto = produtoRepository.findAllById(temp).get(0);
		
		return produto;
	}
}

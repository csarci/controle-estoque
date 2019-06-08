package br.com.gm5.estoque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.gm5.estoque.model.Loja;
import br.com.gm5.estoque.model.Produto;
import br.com.gm5.estoque.service.EstoqueService;

@Controller
public class ProdutoController {
	
	@Autowired
	private EstoqueService service;
	
	@PostMapping("/salvarProduto")
	public ModelAndView gravaProduto(@RequestParam("nome-produto") String nome, @RequestParam("preco-produto") Double preco,
									@RequestParam("id-loja") long lojaId) {
		
		if (nome.isEmpty() || nome == null || preco == null) {
			return new ModelAndView("redirect:editarLoja/" + lojaId);
		}
		
		Loja loja = new Loja();
		loja = service.buscaLojaById(lojaId);
		
		Produto produto = new Produto(nome, preco, loja);
		service.salvaProduto(produto);
		return new ModelAndView("redirect:editarLoja/" + lojaId);
	}
	
	@GetMapping("/deletarProduto/{id}")
	public ModelAndView deletaProduto(@PathVariable("id") Long id) {
		Produto prod = service.buscaProdutoById(id);
		service.deletarProduto(id);
		return new ModelAndView("redirect:/editarLoja/" + prod.getLoja().getId());
	}
	
	@GetMapping("/editarProduto/{id}")
	public ModelAndView retornaProduto(@PathVariable("id") Long id) {
		
		Produto produto = new Produto();
		produto = service.buscaProdutoById(id);
		
		ModelAndView mv = new ModelAndView("/produtos");
		mv.addObject("produto", produto);
		
		return mv;
	}
	
	@PostMapping("/atualizarProduto")
	public ModelAndView atualizaProduto(Produto produto) {
		
		if (produto.getNome().isEmpty() || produto.getNome() == null || produto.getPreco() == null) {
			return new ModelAndView("redirect:/editarProduto/" + produto.getId());
		}
		
		Produto novoProduto = new Produto();
		novoProduto = service.buscaProdutoById(produto.getId());
		novoProduto.setNome(produto.getNome());
		novoProduto.setPreco(produto.getPreco());
		service.salvaProduto(novoProduto);	
		
		return new ModelAndView("redirect:/editarLoja/" + novoProduto.getLoja().getId());
	}
}

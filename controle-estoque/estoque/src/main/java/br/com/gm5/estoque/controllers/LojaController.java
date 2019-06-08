package br.com.gm5.estoque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gm5.estoque.model.Loja;
import br.com.gm5.estoque.model.Produto;
import br.com.gm5.estoque.service.EstoqueService;

@Controller
public class LojaController {
	
	@Autowired
	private EstoqueService service;
	
	@GetMapping("/deletarLoja/{id}")
	public ModelAndView deletaLoja(@PathVariable("id") Long id) {
		
		List<Produto> produtos = service.buscaProdutosByLojaId(id);
		
		if (produtos.size() > 0) {
			for (int i = 0; i < produtos.size(); i++) {
				service.deletarProduto(produtos.get(i).getId());
			}
		}
		
		service.deletarLoja(id);
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/editarLoja/{id}")
	public ModelAndView retornaLoja(@PathVariable("id") Long id) {
		
		Loja loja = new Loja();
		loja = service.buscaLojaById(id);
		
		List<Produto> produtos = service.buscaProdutosByLojaId(id);

		ModelAndView mv = new ModelAndView("/lojas");
		mv.addObject("loja", loja);
		mv.addObject("produtos", produtos);
		
		return mv;
	}
	
	@PostMapping("/atualizarLoja")
	public ModelAndView atualizaLoja(Loja loja) {
		
		if (loja.getNome().isEmpty() || loja.getNome() == null) {
			return new ModelAndView("redirect:/");
		}
		
		Loja novaLoja = new Loja();
		novaLoja = service.buscaLojaById(loja.getId());
		novaLoja.setNome(loja.getNome());		
		service.salvaLoja(novaLoja);	
		
		return new ModelAndView("redirect:/");
	}
}

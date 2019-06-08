package br.com.gm5.estoque.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.gm5.estoque.model.Loja;
import br.com.gm5.estoque.service.EstoqueService;

@Controller
public class EstoqueController {
	
	@Autowired
	private EstoqueService service;

	@GetMapping("/")
	public ModelAndView buscaEstoque() {
		ModelAndView mv = new ModelAndView("/estoque");
		mv.addObject("lojas", service.findAllLojas());
		return mv;
	}
	
	@PostMapping("/salvarLoja")
	public ModelAndView gravaLoja(@RequestParam("nome-loja") @Valid String nome) {
		if(nome.isEmpty() || nome == null){
			return buscaEstoque();
	    }
		
		Loja loja = new Loja (nome);
		service.salvaLoja(loja);
		return buscaEstoque();
	}

}

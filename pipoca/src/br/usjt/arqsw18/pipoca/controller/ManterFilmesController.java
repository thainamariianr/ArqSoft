package br.usjt.arqsw18.pipoca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw18.pipoca.model.entity.Filme;
import br.usjt.arqsw18.pipoca.model.service.FilmeService;

@Controller
public class ManterFilmesController {
	private FilmeService filmeService;
	
	public ManterFilmesController(){
		filmeService = new FilmeService();
	}
	
	@RequestMapping("/filme/novo")
	public String novoFilme(){
		return "NovoFilme";
	}
	
	@RequestMapping("/filme/inserir")
	public String inserirFilme(Filme filme, Model model) {
		int id = filmeService.inserirFilme(filme);
		filme.setId(id);
		model.addAttribute("filme", filme);
		
		return "Resultado";
	}
}

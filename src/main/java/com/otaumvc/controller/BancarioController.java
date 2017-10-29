package com.otaumvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.otaumvc.model.Bancario;
import com.otaumvc.service.BancarioService;
/**
 * Controller para controlar as requisi��es e devolver os 
 * dados necess�rios
 * @author Luis
 *
 */
@Controller
public class BancarioController {
	
	private BancarioService bancarioService;
	
	@Autowired(required=true)
	@Qualifier(value="bancarioService")
	public void setBancarioService(BancarioService bancarioService){
		this.bancarioService = bancarioService;
	}
	
	// Mapenado url bancario que retorna uma lista
	// de bancarios
	@RequestMapping(value = "/bancario", method = RequestMethod.GET)
	public String listaBancarios(Model model) {
		model.addAttribute("bancario", new Bancario());
		model.addAttribute("listaBancarios", this.bancarioService.listaBancarios());
		return "bancario";
	}
	
	// Mapeando url que adiciona e atualiza
	@RequestMapping(value= "/bancario/add", method = RequestMethod.POST)
	public String addBancario(@ModelAttribute("bancario") Bancario bancario){
		// Verifica se o bancario n�o existe
		if(bancario.getId() == 0){
			//Novo bancario, adicionar
			this.bancarioService.addBancario(bancario);
		}else{
			//J� existe, atualiza
			this.bancarioService.updateBancario(bancario);
		}
		
		// Requisi��o get para url /bancarios
		return "redirect:/bancario";
		
	}
	
	// Recebe id no caminho da url para remover Bancario
	@RequestMapping("/remove/{id}")
    public String removeBancario(@PathVariable("id") int id){
		
        this.bancarioService.removeBancario(id);
        return "redirect:/bancario";
    }
	// Recebe id no caminho da url para editar Bancario
    @RequestMapping("/edit/{id}")
    public String editBancario(@PathVariable("id") int id, Model model){
        model.addAttribute("bancario", this.bancarioService.getBancarioById(id));
        model.addAttribute("listaBancarios", this.bancarioService.listaBancarios());
        return "bancario";
    }
	
}

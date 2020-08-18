package com.uverwolf.dojoNinja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uverwolf.dojoNinja.models.Dojo;
import com.uverwolf.dojoNinja.models.Ninja;
import com.uverwolf.dojoNinja.services.DojoServices;

@Controller
public class DojoController {
	private final DojoServices servicios;
	public DojoController(DojoServices serv) {
		this.servicios = serv;
	}
	
	@GetMapping("/dojos")
	public String index() {
		return "/vistas/index.jsp";
	}
	
	@GetMapping("/dojos/dojos")
	public String dojos(@ModelAttribute("DojoValido")Dojo dojo) {
		return "/vistas/dojo.jsp";
	}
	
	@PostMapping("/dojos/dojos")
	public String crearDojo(@ModelAttribute("DojoValido")Dojo dojo,BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "vistas/dojo.jsp";
		}else {
			servicios.crearDojo(dojo);
			return "redirect:/dojos";
		}
	}
	
	@GetMapping("dojos/ninjas")
	public String ninjas(@ModelAttribute("ninjaValido")Ninja nin,Model modelo) {
		modelo.addAttribute("dojos", servicios.verTodos());
		return "/vistas/ninja.jsp";
	}
	
	@PostMapping("dojos/ninjas")
	public String crearNinja(@ModelAttribute("ninjaValido")Ninja nin,BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "/vistas/ninjas.jsp";
		}else {
			servicios.crearNinja(nin);
			return "redirect:/dojos";
		}
	}
	
	@GetMapping("dojos/{id}")
	public String listadoNinjas(@PathVariable("id") Long id,Model modelo){
		modelo.addAttribute("ninjas",servicios.verNinjasDojos(id));
		return "/vistas/verTodos.jsp";
		
	}
	@GetMapping("dojos/ver")
	public String verDojos(Model modelo){
		modelo.addAttribute("dojos",servicios.verTodos());
		return "/vistas/verDojos.jsp";
	}
	
}

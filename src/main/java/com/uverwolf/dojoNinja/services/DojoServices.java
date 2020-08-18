package com.uverwolf.dojoNinja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uverwolf.dojoNinja.models.Dojo;
import com.uverwolf.dojoNinja.models.Ninja;
import com.uverwolf.dojoNinja.repositories.DojosRepository;
import com.uverwolf.dojoNinja.repositories.NinjaRepo;

@Service
public class DojoServices {
	private final DojosRepository servicios;
	private final NinjaRepo	servninja;
	public DojoServices(DojosRepository serv,NinjaRepo servN) {
		this.servicios=serv;
		this.servninja=servN;
	}
	
	public List<Dojo> verTodos(){
		return servicios.findAll();
	}
	public Dojo crearDojo(Dojo dojo) {
		return servicios.save(dojo);
	}
	public Ninja crearNinja(Ninja ninja) {
		return servicios.save(ninja);
	}
	public List<Ninja> verNinjasDojos(Long id){
		return servninja.findByDojo_id(id);
	}
}

package com.uverwolf.dojoNinja.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.uverwolf.dojoNinja.models.Dojo;
import com.uverwolf.dojoNinja.models.Ninja;

public interface DojosRepository extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();

	Ninja save(Ninja ninja);
}

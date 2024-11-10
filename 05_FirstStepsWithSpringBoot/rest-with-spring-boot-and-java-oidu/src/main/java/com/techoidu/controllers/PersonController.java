package com.techoidu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techoidu.data.vo.v1.PersonVO;
import com.techoidu.data.vo.v1.v2.PersonVOV2;
import com.techoidu.services.PersonService;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonService service;

	@GetMapping()
	public List<PersonVO > findAll() throws Exception {
		return service.findAll();
	}
	
	@GetMapping(value ="/{id}")
	public PersonVO  findById(@PathVariable Long id) throws Exception {
		return service.findById(id);
	}
	
	@PostMapping()
	public PersonVO create(@RequestBody PersonVO  person) throws Exception {
		return service.create(person);
	}
	
	@PostMapping(value = "/v2")
	public PersonVOV2  createV2(@RequestBody PersonVOV2  person) throws Exception {
		return service.createV2(person);
	}
	
	@PutMapping()
	public PersonVO update(@RequestBody PersonVO  person) throws Exception {
		return service.update(person);
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}

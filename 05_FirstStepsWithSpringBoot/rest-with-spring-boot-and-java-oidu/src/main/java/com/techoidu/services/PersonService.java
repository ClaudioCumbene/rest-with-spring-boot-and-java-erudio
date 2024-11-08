package com.techoidu.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoidu.data.vo.v1.PersonVO;
import com.techoidu.data.vo.v1.v2.PersonVOV2;
import com.techoidu.entities.Person;
import com.techoidu.exceptions.ResourceNotFoundException;
import com.techoidu.mapper.DozerMapper;
import com.techoidu.mapper.custom.PersonMapper;
import com.techoidu.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());

	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;

	public List<PersonVO> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(repository.findAll(),PersonVO.class);
	}

	public PersonVO findById(Long id) {
		logger.info("Finding one Person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
		return DozerMapper.parseObject(entity,PersonVO.class);
				
	}

	public PersonVO create(PersonVO person) {
		logger.info("Creating one person!");
		
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo = DozerMapper.parseObject(repository.save(entity),PersonVO.class);
		return vo;
		
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("Creating one person V2!");
		
		var entity = mapper.convertVoToEntity(person);
		var vo = mapper.convertEntityToVo(repository.save(entity));
		return vo;
		
	}

	public PersonVO update(PersonVO person) {
		logger.info("Updating one person!");
		
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerMapper.parseObject(repository.save(entity),PersonVO.class);
		return vo;
	}

	public void delete(Long id) {
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
		repository.delete(entity); 
	}

}

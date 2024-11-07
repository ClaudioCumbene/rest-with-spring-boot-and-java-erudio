package com.techoidu.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.techoidu.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person create(Person person) {
		
		logger.info("Creating one person!");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one person!");
		
	}
	
	public List<Person> findAll() {
		logger.info("Finding all people!");
		
		List<Person> persons = new ArrayList<>();
		for(int i=0; i<8;i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}

	public Person findById(String id) {
		
		logger.info("Finding one Person!");
		
		Person person= new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Claudio");
		person.setLastName("Cumbene");
		person.setAddress("Albazine- maputo");
		person.setGender("Male");
		return person;
	}
	
	private Person mockPerson(int i) {
		Person person= new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person Name " +i);
		person.setLastName("Last Name " +i);
		person.setAddress("Some address in Mz " +i);
		person.setGender("Male");
		return person;
	}
}

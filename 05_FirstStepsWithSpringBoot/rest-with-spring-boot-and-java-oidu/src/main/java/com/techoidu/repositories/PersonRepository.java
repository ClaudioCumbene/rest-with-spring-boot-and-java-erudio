package com.techoidu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techoidu.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

package com.techoidu.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.techoidu.data.vo.v1.v2.PersonVOV2;
import com.techoidu.entities.Person;

@Service
public class PersonMapper {
	
	public PersonVOV2 convertEntityToVo(Person person){
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setGender(person.getGender());
		vo.setLastName(person.getLastName());
		return vo;
	}
	
	public Person convertVoToEntity(PersonVOV2 person){
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		//entity.setBirthDay(new Date());
		entity.setFirstName(person.getFirstName());
		entity.setGender(person.getGender());
		entity.setLastName(person.getLastName());
		return entity; 
	}
	
}

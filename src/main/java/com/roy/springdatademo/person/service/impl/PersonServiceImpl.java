package com.roy.springdatademo.person.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roy.springdatademo.person.Person;
import com.roy.springdatademo.person.repository.PersonRepository;
import com.roy.springdatademo.person.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	private final static Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public void save(Person person) {
		personRepository.save(person);
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	@Override
	public Person getOne(Long id) {
		return personRepository.getOne(id);
	}

	@Override
	public Person delete(Long id) {
		Person person = this.getOne(id);
		personRepository.delete(person);
		return person;
	}

	@Override
	public List<Person> findByName(String name) {
		return personRepository.findByName(name);
	}

	@Override
	public List<Person> findByAgeAndSex(int age, int sex) {
		return personRepository.findByAgeAndSex(age, sex);
	}

	@Override
	public List<Person> searchByName(String name) {
		return personRepository.searchByName(name);
	}
	
	
}

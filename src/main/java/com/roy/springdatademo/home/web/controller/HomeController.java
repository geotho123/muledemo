package com.roy.springdatademo.home.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.roy.springdatademo.person.Person;
import com.roy.springdatademo.person.service.PersonService;

@RestController
public class HomeController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/person")
	public List<Person> person() {
		return personService.findAll();
	}
	
	@RequestMapping(value = "/person/add",method=RequestMethod.POST)
	public String add(Person person) {
		personService.save(person);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/person/{id:\\d+$}")
	public Person detail(@PathVariable(value="id") long id) {
		return personService.getOne(id);
	}
	
	@RequestMapping(value = "/person/delete/{id:\\d+$}")
	public ResponseEntity<Person> delete(@PathVariable(value="id") long id) {
		return new ResponseEntity(personService.delete(id),HttpStatus.OK);
	}
}

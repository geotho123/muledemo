package com.roy.muledemo.home.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roy.muledemo.person.Person;
import com.roy.muledemo.person.service.PersonService;

@Controller
public class HomeController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/person")
	@ResponseBody
	public List<Person> person() {
		return personService.findAll();
	}
	
	@RequestMapping(value = "/person/add",method=RequestMethod.POST)
	public String add(Person person) {
		personService.save(person);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/person/{id:\\d+$}")
	@ResponseBody
	public Person detail(@PathVariable(value="id") long id) {
		return personService.getOne(id);
	}
	
	@RequestMapping(value = "/person/delete/{id:\\d+$}")
	@ResponseBody
	public ResponseEntity<Person> delete(@PathVariable(value="id") long id) {
		return new ResponseEntity(personService.delete(id),HttpStatus.OK);
	}
}

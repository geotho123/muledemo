package com.roy.springdatademo.person.service;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.roy.springdatademo.BaseTestCase;
import com.roy.springdatademo.person.Person;

public class TestPersonService extends BaseTestCase {
	
	@Autowired
	private PersonService personService;
	
	@Test
	public void testSave() {
		Person person = new Person();
		person.setName("roy");
		person.setAge(26);
		person.setSex(1);
		person.setAddress("Tianjin");
		personService.save(person);
	}
	
	@Test
	public void testFindAll() {
		List<Person> personList = personService.findAll();
		Assert.assertEquals(1, personList.size());
		Assert.assertEquals("roy", personList.get(0).getName());
	}
	
	@Test
	public void testFindByName() {
		List<Person> personList = personService.findByName("roy");
		Assert.assertEquals(1, personList.size());
		Assert.assertEquals("roy", personList.get(0).getName());
	}
	
	@Test
	public void testSearchByName() {
		List<Person> personList = personService.searchByName("r");
		Assert.assertEquals(1, personList.size());
		Assert.assertEquals("roy", personList.get(0).getName());
	}
	
	@Test
	public void testFindByAgeAndSex() {
		List<Person> personList = personService.findByAgeAndSex(26,1);
		Assert.assertEquals(1, personList.size());
		Assert.assertEquals("roy", personList.get(0).getName());
	}
	
	//@Test
	public void testDelete() {
		List<Person> personList = personService.findAll();
		for(Person person : personList) {
			personService.delete(person.getId());
		}
	}
	

}

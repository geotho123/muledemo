package com.roy.springdatademo.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roy.springdatademo.person.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	public List<Person> findByName(String name);
	
	@Query("from Person p where p.name like %:name%")
	public List<Person> searchByName(@Param("name") String name);
	
	@Query("from Person p where p.age = :age and p.sex = :sex")
	public List<Person> findByAgeAndSex(@Param("age") int age, @Param("sex") int sex);
}

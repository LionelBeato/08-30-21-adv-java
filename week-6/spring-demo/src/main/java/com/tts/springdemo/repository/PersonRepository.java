package com.tts.springdemo.repository;

import com.tts.springdemo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findAllByFirstName(String firstName);

}

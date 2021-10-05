package com.tts.springdemo.service;

import com.tts.springdemo.model.Person;
import com.tts.springdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// this is the implementation for our service
// it implements all the actual methods
// and sets up any dependencies
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public List<Person> getAllById(List<Long> id) {
        return (List<Person>) personRepository.findAllById(id);
    }

    @Override
    public List<Person> getPersonByFirstName(String firstName) {
        return personRepository.findAllByFirstName(firstName);
    }
}

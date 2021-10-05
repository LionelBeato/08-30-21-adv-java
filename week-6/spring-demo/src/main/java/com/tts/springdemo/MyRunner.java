package com.tts.springdemo;

import com.tts.springdemo.model.Person;
import com.tts.springdemo.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyRunner {
    @Bean
    public CommandLineRunner runner(PersonRepository personRepository) {
        return (args) -> {
            personRepository.save(new Person("Mickey", "Mouse", LocalDate.MIN));
            personRepository.save(new Person("Minnie", "Mouse", LocalDate.MIN));
            personRepository.save(new Person("Donald", "Duck", LocalDate.MIN));
        };
    }
}

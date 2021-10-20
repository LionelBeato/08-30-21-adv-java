package com.tts.restdemo.controller;

import com.tts.restdemo.model.Greeting;
import com.tts.restdemo.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SimpleController {

    @Autowired
    SimpleService simpleService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value="name",
            defaultValue="World") String name) {
        return new Greeting(
                counter.incrementAndGet(),
                String.format(template, name));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/teapot")
    public ResponseEntity<String> teapot() {
        return new ResponseEntity<>("Hello, I am a teapot", HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/age")
    ResponseEntity<String> age(@RequestParam("yearOfBirth") int yearOfBirth) {

        if (simpleService.isInFuture(yearOfBirth)) {
            return new ResponseEntity<>(
                    "Year of birth cannot be in the future",
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
            "Your age is " + simpleService.calculateAge(yearOfBirth),
                HttpStatus.OK);
        }


    // TODO: implement a service for this business logic
//    private boolean isInFuture(int yearOfBirth) {
//        return yearOfBirth > 2021;
//    }
//
//    private int calculateAge(int yearOfBirth) {
//        return 2021 - yearOfBirth;
//    }







}

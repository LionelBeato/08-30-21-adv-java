package com.tts.restdemo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

    @Test
    void test() {
        Greeting greeting = new Greeting(1, "Hello World!");
        greeting.getContent();
        greeting.getId();
    }


}
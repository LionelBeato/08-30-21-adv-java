package com.tts.restdemo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class SimpleServiceImpl implements SimpleService{

//    private Date dt = new Date();
    LocalDate currentDate = LocalDate.now();
    int currentYear = currentDate.getYear();

    @Override
    public boolean isInFuture(int yearOfBirth) {
        return yearOfBirth > currentYear;
    }

    @Override
    public int calculateAge(int yearOfBirth) {
        return currentYear - yearOfBirth;
    }
}

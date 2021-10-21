package com.tts.validationdemo.controller;

import com.tts.validationdemo.model.MovieRental;
import com.tts.validationdemo.repository.MovieRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rentals")
public class MovieRentalController {

    @Autowired
    MovieRentalRepository movieRentalRepository;

    @PostMapping
    public ResponseEntity<Void> createRental(@RequestBody @Valid MovieRental movieRental,
                                             BindingResult bindingResult) {

        if (movieRentalRepository.findByEmailAddress(movieRental.getEmailAddress()) != null) {
            bindingResult.rejectValue("emailAddress",
                    "error.email",
                    "Email address is already taken");
        }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        movieRentalRepository.save(movieRental);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

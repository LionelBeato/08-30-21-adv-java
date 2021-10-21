package com.tts.validationdemo.repository;

import com.tts.validationdemo.model.MovieRental;
import org.springframework.data.repository.CrudRepository;

public interface MovieRentalRepository extends CrudRepository<MovieRental, Long> {
    MovieRental findByEmailAddress(String emailAddress);
}

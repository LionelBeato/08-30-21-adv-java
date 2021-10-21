package com.tts.validationdemo.repository;

import com.tts.validationdemo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

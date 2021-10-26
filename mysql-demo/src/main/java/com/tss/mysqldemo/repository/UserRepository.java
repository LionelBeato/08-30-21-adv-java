package com.tss.mysqldemo.repository;

import com.tss.mysqldemo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

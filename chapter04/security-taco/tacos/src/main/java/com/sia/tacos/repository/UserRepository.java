package com.sia.tacos.repository;

import java.util.List;

import com.sia.tacos.domain.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}

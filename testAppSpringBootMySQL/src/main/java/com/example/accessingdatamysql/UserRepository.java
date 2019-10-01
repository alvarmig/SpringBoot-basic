package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}

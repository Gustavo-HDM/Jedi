package com.jedi.jedi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jedi.jedi.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findByLogin(String login);
	
}
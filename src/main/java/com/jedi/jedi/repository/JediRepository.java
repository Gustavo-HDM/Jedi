package com.jedi.jedi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jedi.jedi.domain.Jedi;

@Repository
public interface JediRepository extends CrudRepository<Jedi, Long> {
	
//	@Query("SELECT")
	public List<Jedi> findByName(String name);
}
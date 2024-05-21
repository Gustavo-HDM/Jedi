package com.jedi.jedi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jedi.jedi.domain.Jedi;

@Repository
public interface JediRepository extends CrudRepository<Jedi, Long> {}

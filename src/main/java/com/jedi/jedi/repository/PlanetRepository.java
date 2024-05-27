package com.jedi.jedi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jedi.jedi.domain.Planet;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long>{}
package com.jedi.jedi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jedi.jedi.domain.Planet;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long>{
	
	@Query (value = "SELECT p FROM Planet p WHERE userId = :userId")
	public List<Planet> getAllPlanet(@Param("userId") Long userId);
}
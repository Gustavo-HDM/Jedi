package com.jedi.jedi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jedi.jedi.domain.Jedi;

@Repository
public interface JediRepository extends CrudRepository<Jedi, Long> {
	
	@Query(value = "SELECT j FROM Jedi j WHERE j.powerLevel between :min_power and :max_power")
    List<Jedi> filterPowerJedi(@Param("min_power") Integer minPower, @Param("max_power") Integer maxPower);
}
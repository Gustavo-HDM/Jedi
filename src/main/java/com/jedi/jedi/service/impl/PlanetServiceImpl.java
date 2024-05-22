package com.jedi.jedi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jedi.jedi.domain.Planet;
import com.jedi.jedi.repository.PlanetRepository;
import com.jedi.jedi.service.PlanetService;

public class PlanetServiceImpl implements PlanetService{

	@Autowired
	private PlanetRepository repository;
	
	@Override
	public void addPlanet(Planet planet) {
		repository.save(planet);
	}

	@Override
	public Planet getPlanet(Long id) {
		Optional<Planet> planetOpt = repository.findById(id);
		return planetOpt.orElse(null);
	}

}

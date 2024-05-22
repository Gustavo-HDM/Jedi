package com.jedi.jedi.service;

import com.jedi.jedi.domain.Planet;

public interface PlanetService {

	public void addPlanet(Planet planet);
	public Planet getPlanet(Long id);
}
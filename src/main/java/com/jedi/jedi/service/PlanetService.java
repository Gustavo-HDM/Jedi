package com.jedi.jedi.service;

import com.jedi.jedi.domain.Planet;
import com.jedi.jedi.dto.PlanetRequestDTO;

public interface PlanetService {

	/**
	 * Method do add an Planet to the database
	 * @throws PlanetException
	 * @param planet
	 */
	public void addPlanet(PlanetRequestDTO planetDTO);
	
	/**
	 * Method to bring an Planet from the database
	 * @return planet
	 * @throws PlanetNullException
	 * @param id
	 */
	public Planet getPlanet(Long id);
	
	/**
	 * Method to delete an Planet from the database
	 * @throws PlanetException
	 * @param id
	 */
	public void delPlanet(Long id);
	
	/**
	 * Method to alter a Planet's data from the database
	 * @throws PlanetException, PlanetNullException
	 * @param id
	 * @param planet
	 */
	public void uptPlanet(Long id, PlanetRequestDTO planetDTO);
}
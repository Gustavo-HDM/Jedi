package com.jedi.jedi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedi.jedi.domain.Planet;
import com.jedi.jedi.domain.User;
import com.jedi.jedi.dto.PlanetRequestDTO;
import com.jedi.jedi.exceptions.RequestNotFoundException;
import com.jedi.jedi.repository.PlanetRepository;
import com.jedi.jedi.service.PlanetService;
import com.jedi.jedi.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class PlanetServiceImpl implements PlanetService{

	@Autowired
	private PlanetRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public void addPlanet(PlanetRequestDTO planetDTO) {
		Planet planet = new Planet(planetDTO);
		User user = userService.getUserId();
		planet.setUserId(user);
		repository.save(planet);
	}

	@Override
	public Planet getPlanet(Long id) {
		Optional<Planet> planetOpt = repository.findById(id);
		return planetOpt.orElseThrow(() -> new RequestNotFoundException("Planeta de id: " + id + " nao encontrado"));
	}

	@Override
	public void delPlanet(Long id) {
		repository.deleteById(id);
	}

	@Transactional
	@Override
	public void uptPlanet(Long id, PlanetRequestDTO planetDTO) {
		Optional<Planet> planetOpt = repository.findById(id);
		if (planetOpt.isPresent()) {
			Planet planet = new Planet(planetDTO);
			planet.setId(id);
			repository.save(planet);
		}
	}

}

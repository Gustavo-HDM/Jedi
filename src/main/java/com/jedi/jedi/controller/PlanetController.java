package com.jedi.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jedi.jedi.domain.Planet;
import com.jedi.jedi.service.PlanetService;

@RestController
@RequestMapping("/jedi") //REVER
@CrossOrigin(origins = "*")
public class PlanetController {

	@Autowired
	private PlanetService service;
	
	@PostMapping
	public ResponseEntity<Planet> saveJedi(@RequestBody Planet planet) {
		service.addPlanet(planet);
		return ResponseEntity.ok().build();
	}
}

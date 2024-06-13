package com.jedi.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jedi.jedi.domain.Planet;
import com.jedi.jedi.dto.PlanetRequestDTO;
import com.jedi.jedi.exceptions.RequestNotFoundException;
import com.jedi.jedi.service.PlanetService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/planet")
@CrossOrigin(origins = "*")
public class PlanetController {

	@Autowired
	private PlanetService service;
	
	@PostMapping
	public ResponseEntity<Planet> savePlanet(@RequestBody PlanetRequestDTO planetDTO) {
		service.addPlanet(planetDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Object> getPlanet(@PathVariable Long id) {
		try {
			Planet planet = service.getPlanet(id);
			return ResponseEntity.ok(planet);
		} catch (RequestNotFoundException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Planet> delPlanet(@PathVariable Long id) {
		service.delPlanet(id);
		return ResponseEntity.ok().build();
	}
	
	@Transactional
	@PutMapping ("/{id}")
	public ResponseEntity<Planet> uptPlanet(@PathVariable Long id, @RequestBody PlanetRequestDTO planetDTO) {
		service.uptPlanet(id, planetDTO);
		return ResponseEntity.ok().build();
	}
}

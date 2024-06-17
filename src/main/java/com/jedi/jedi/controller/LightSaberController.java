package com.jedi.jedi.controller;

import java.util.List;

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

import com.jedi.jedi.domain.LightSaber;
import com.jedi.jedi.dto.LightSaberRequestDTO;
import com.jedi.jedi.exceptions.DuplicatedLightSaber;
import com.jedi.jedi.service.LightSaberService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/light_saber")
@CrossOrigin(origins = "*")
public class LightSaberController {

	@Autowired
	private LightSaberService service;

	@PostMapping
	public ResponseEntity<Object> saveLightSaber(@RequestBody LightSaberRequestDTO lightSaberDTO) {
		try {
			service.addLightSaber(lightSaberDTO);
		} catch (DuplicatedLightSaber e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<LightSaber> getLightSaber(@PathVariable Long id) {
		LightSaber lightSaber = service.getLightSaber(id);
		return ResponseEntity.ok(lightSaber);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<LightSaber> delLightSaber(@PathVariable Long id) {
		service.delLightSaber(id);
		return ResponseEntity.ok().build();
	}

	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<LightSaber> uptLightSaber(@PathVariable Long id,
			@RequestBody LightSaberRequestDTO lightSaberDTO) {
		service.uptLightSaber(id, lightSaberDTO);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<LightSaber>> getAllLightSaber() {
		List<LightSaber> lightSaberList = service.getAllLightSaber();
		return ResponseEntity.ok(lightSaberList);
	}
}

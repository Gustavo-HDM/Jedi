package com.jedi.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jedi.jedi.domain.LightSaber;
import com.jedi.jedi.service.LightSaberService;

@RestController
@RequestMapping("/jedi") //REVER
@CrossOrigin(origins = "*")
public class LightSaberController {

	@Autowired
	private LightSaberService service;
	
	@PostMapping
	public ResponseEntity<LightSaber> saveLightSaber(@RequestBody LightSaber lightSaber) {
		service.addLightSaber(lightSaber);
		return ResponseEntity.ok().build();
	}
}

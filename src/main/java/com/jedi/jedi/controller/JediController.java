package com.jedi.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jedi.jedi.domain.Jedi;
import com.jedi.jedi.dto.JediRequestDTO;
import com.jedi.jedi.service.JediService;

@RestController
@RequestMapping("/jedi")
@CrossOrigin(origins = "*")
public class JediController {

	@Autowired
	private JediService service;
	
	@PostMapping
	public ResponseEntity<Jedi> saveJedi(@RequestBody JediRequestDTO jedi) {
		//service.addJedi(jedi);
		service.addJedi(jedi);
		return ResponseEntity.status(201).build();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Jedi> getJedi(@PathVariable Long id){
		Jedi jedi = service.getJedi(id);
		return ResponseEntity.ok(jedi);
	}
}

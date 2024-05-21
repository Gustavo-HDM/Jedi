package com.jedi.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jedi.jedi.domain.Jedi;
import com.jedi.jedi.service.JediService;

@RestController
@RequestMapping("/jedi")
@CrossOrigin(origins = "*")
public class JediController {

	@Autowired
	private JediService service;

	@PostMapping
	public ResponseEntity<Jedi> saveJedi(@RequestBody Jedi jedi) {
		service.addJedi(jedi);
		return ResponseEntity.ok().build();
	}
}

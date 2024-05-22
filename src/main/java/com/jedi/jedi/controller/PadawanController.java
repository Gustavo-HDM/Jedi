package com.jedi.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jedi.jedi.domain.Padawan;
import com.jedi.jedi.service.PadawanService;

@RestController
@RequestMapping("/jedi") //REVER
@CrossOrigin(origins = "*")
public class PadawanController {

	@Autowired
	private PadawanService service;
	
	@PostMapping
	public ResponseEntity<Padawan> saveJedi(@RequestBody Padawan padawan) {
		service.addPadawan(padawan);
		return ResponseEntity.ok().build();
	}
}

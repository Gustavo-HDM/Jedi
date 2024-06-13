package com.jedi.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.jedi.jedi.domain.Padawan;
import com.jedi.jedi.dto.PadawanRequestDTO;
import com.jedi.jedi.dto.PadawanResponseDTO;
import com.jedi.jedi.service.PadawanService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/padawan")
@CrossOrigin(origins = "*")
public class PadawanController {

	@Autowired
	private PadawanService service;
	
	@PostMapping
	public ResponseEntity<Padawan> savePadawan(@RequestBody PadawanRequestDTO padawanDTO) {
		service.addPadawan(padawanDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<PadawanResponseDTO> getPadawan(@PathVariable Long id) {
		PadawanResponseDTO padawan = service.getPadawan(id);
		return ResponseEntity.ok(padawan);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Padawan> delPadawan(@PathVariable Long id) {
		service.delPadawan(id);
		return ResponseEntity.ok().build();
	}
	
	@Transactional
	@PutMapping ("/{id}")
	public ResponseEntity<Padawan> uptPadawan(@PathVariable Long id, @RequestBody PadawanRequestDTO padawanDTO) {
		service.uptPadawan(id, padawanDTO);
		return ResponseEntity.ok().build();
	}
}

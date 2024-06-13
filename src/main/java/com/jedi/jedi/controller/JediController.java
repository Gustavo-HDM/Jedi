package com.jedi.jedi.controller;

import java.util.List;

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

import com.jedi.jedi.domain.Jedi;
import com.jedi.jedi.dto.JediRequestDTO;
import com.jedi.jedi.dto.JediResponseDTO;
import com.jedi.jedi.dto.PowerLevelRequestDTO;
import com.jedi.jedi.service.JediService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jedi")
@CrossOrigin(origins = "*")
public class JediController {

	@Autowired
	private JediService service;
	
	@PostMapping
	public ResponseEntity<Jedi> saveJedi(@RequestBody @Valid JediRequestDTO jedi) {
		service.addJedi(jedi);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<JediResponseDTO> getJedi(@PathVariable Long id){
		JediResponseDTO jedi = service.getJedi(id);
		return ResponseEntity.ok(jedi);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Jedi> delJedi(@PathVariable Long id) {
		service.delJedi(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Jedi> uptJedi(@PathVariable Long id, @RequestBody @Valid JediRequestDTO jedi) {
		service.uptJedi(id, jedi);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping ("/filterPower")
	public ResponseEntity<List<Jedi>> filterPowerJedi(@RequestBody PowerLevelRequestDTO dto) {
		List<Jedi> jediList = service.filterPowerJedi(dto.minPower(), dto.maxPower());
		return ResponseEntity.ok(jediList);
	}
	
	@GetMapping ("/getAll")
	public ResponseEntity<List<Jedi>> getAllJedi() {
		List<Jedi> jediList = service.getAllJedi();
		return ResponseEntity.ok(jediList);
	}
	
//	private String getUsernameFromSecurityContext() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            return ((UserDetails) principal).getUsername();
//        } else {
//            return principal.toString();
//        }
//    }
}

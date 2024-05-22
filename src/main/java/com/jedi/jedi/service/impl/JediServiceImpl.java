package com.jedi.jedi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedi.jedi.domain.Jedi;
import com.jedi.jedi.repository.JediRepository;
import com.jedi.jedi.service.JediService;

@Service
public class JediServiceImpl implements JediService{

	@Autowired
	private JediRepository repository;
	
	//TODO JEDI RETURN
	@Override
	public void addJedi(Jedi jedi) {
		repository.save(jedi);
	}

	@Override
	public Jedi getJedi(Long id) {
		Optional<Jedi> jediOpt = repository.findById(id);
		return jediOpt.orElse(null);
	}
}
package com.jedi.jedi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedi.jedi.domain.LightSaber;
import com.jedi.jedi.repository.LightSaberRepository;
import com.jedi.jedi.service.LightSaberService;

@Service
public class LightSaberServiceImpl implements LightSaberService {

	@Autowired
	private LightSaberRepository repository;
	
	@Override
	public void addLightSaber(LightSaber lightSaber) {
		repository.save(lightSaber);		
	}

	@Override
	public LightSaber getLightSaber(Long id) {
		Optional<LightSaber> lightSaberOpt = repository.findById(id);
		return lightSaberOpt.orElse(null);
	}
}
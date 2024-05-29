package com.jedi.jedi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedi.jedi.domain.LightSaber;
import com.jedi.jedi.dto.LightSaberRequestDTO;
import com.jedi.jedi.exceptions.DuplicatedLightSaber;
import com.jedi.jedi.repository.LightSaberRepository;
import com.jedi.jedi.service.LightSaberService;

import jakarta.transaction.Transactional;

@Service
public class LightSaberServiceImpl implements LightSaberService {

	@Autowired
	private LightSaberRepository repository;
	
	@Override
	public void addLightSaber(LightSaberRequestDTO lightSaberDTO) {
		if (!isDuplicated(lightSaberDTO.color(), lightSaberDTO.size())) {
		LightSaber lightSaber = new LightSaber(lightSaberDTO);
		repository.save(lightSaber);		
		} else {
			throw new DuplicatedLightSaber("This Light Saber already exists");
		}
	}

	@Override
	public LightSaber getLightSaber(Long id) {
		Optional<LightSaber> lightSaberOpt = repository.findById(id);
		return lightSaberOpt.orElse(null);
	}

	@Override
	public void delLightSaber(Long id) {
		repository.deleteById(id);
	}

	@Transactional
	@Override
	public void uptLightSaber(Long id, LightSaberRequestDTO lightSaberDTO) {
		Optional<LightSaber> LightSaberOpt = repository.findById(id);
		if (LightSaberOpt.isPresent()) {
			LightSaber lightSaber = new LightSaber(lightSaberDTO);
			lightSaber.setId(id);
			repository.save(lightSaber);
		}
	}

	@Override
	public boolean isDuplicated(String color, Double size) {
		List<LightSaber> lightSaberList = repository.isDuplicated(color, size);
		return lightSaberList.size() > 0;
	}
}
package com.jedi.jedi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedi.jedi.domain.Jedi;
import com.jedi.jedi.domain.LightSaber;
import com.jedi.jedi.domain.User;
import com.jedi.jedi.dto.JediRequestDTO;
import com.jedi.jedi.dto.JediResponseDTO;
import com.jedi.jedi.exceptions.RequestNotFoundException;
import com.jedi.jedi.repository.JediRepository;
import com.jedi.jedi.service.JediService;
import com.jedi.jedi.service.LightSaberService;
import com.jedi.jedi.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class JediServiceImpl implements JediService{

	@Autowired
	private JediRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LightSaberService lightSaberService;
	
	@Override
	public void addJedi(JediRequestDTO jediDTO) {
		LightSaber lightSaber = lightSaberService.getLightSaber(jediDTO.idLightSaber());
		Jedi jedi = new Jedi(jediDTO, lightSaber);
		User user = userService.getUserId();
		jedi.setUserId(user);
		repository.save(jedi);
	}

	@Override
	public JediResponseDTO getJedi(Long id) {
		Optional<Jedi> jediOpt = repository.findById(id);		
        return jediOpt.map(jedi -> new JediResponseDTO(jedi.getName(), jedi.getRace(), jedi.getPowerLevel()))
                      .orElseThrow(() -> new RequestNotFoundException("Jedi not found with id " + id));
	}

	@Override
	public void delJedi(Long id) {
		repository.deleteById(id);
	}

	@Transactional
	@Override
	public void uptJedi(Long id, JediRequestDTO jediDTO) {
        Optional<Jedi> jediOpt = repository.findById(id);
        if (jediOpt.isPresent()) {
        	Jedi jedi = new Jedi(jediDTO);
        	jedi.setId(id);
            repository.save(jedi);
        }
    }

	@Override
	public List<Jedi> filterPowerJedi(Integer minPower, Integer maxPower) {
		return repository.filterPowerJedi(minPower, maxPower);
	}

	@Override
	public List<Jedi> getAllJedi() {
		User user = userService.getUserId(); 
		return repository.getAllJedi(user.getId());
	}
}
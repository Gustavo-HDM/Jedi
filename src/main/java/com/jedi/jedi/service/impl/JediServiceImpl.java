package com.jedi.jedi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedi.jedi.domain.Jedi;
import com.jedi.jedi.dto.JediRequestDTO;
import com.jedi.jedi.repository.JediRepository;
import com.jedi.jedi.service.JediService;

import jakarta.transaction.Transactional;

@Service
public class JediServiceImpl implements JediService{

	@Autowired
	private JediRepository repository;
	
//	@Override
//	public void addJedi(Jedi jedi) {
//		repository.save(jedi);
//	}
	
	@Override
	public void addJedi(JediRequestDTO jediDTO) {
		Jedi jedi = new Jedi(jediDTO);
		repository.save(jedi);
	}

	@Override
	public Jedi getJedi(Long id) {
		Optional<Jedi> jediOpt = repository.findById(id);
		return jediOpt.orElse(null);
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
}
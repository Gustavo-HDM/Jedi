package com.jedi.jedi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedi.jedi.domain.Padawan;
import com.jedi.jedi.repository.PadawanRepository;
import com.jedi.jedi.service.PadawanService;

@Service
public class PadawanServiceImpl implements PadawanService{

	@Autowired
	private PadawanRepository repository;
	
	@Override
	public void addPadawan(Padawan padawan) {
		repository.save(padawan);
	}

	@Override
	public Padawan getPadawan(Long id) {
		Optional<Padawan> padawanOpt = repository.findById(id);
		return padawanOpt.orElse(null);
	}
}

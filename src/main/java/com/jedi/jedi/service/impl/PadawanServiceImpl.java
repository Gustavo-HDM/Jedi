package com.jedi.jedi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedi.jedi.domain.Padawan;
import com.jedi.jedi.dto.PadawanRequestDTO;
import com.jedi.jedi.repository.PadawanRepository;
import com.jedi.jedi.service.PadawanService;

import jakarta.transaction.Transactional;

@Service
public class PadawanServiceImpl implements PadawanService{

	@Autowired
	private PadawanRepository repository;
	
	@Override
	public void addPadawan(PadawanRequestDTO padawanDTO) {
		Padawan padawan = new Padawan(padawanDTO);
		repository.save(padawan);
	}

	@Override
	public Padawan getPadawan(Long id) {
		Optional<Padawan> padawanOpt = repository.findById(id);
		return padawanOpt.orElse(null);
	}

	@Override
	public void delPadawan(Long id) {
		repository.deleteById(id);
	}

	@Transactional
	@Override
	public void uptPadawan(Long id, PadawanRequestDTO padawanDTO) {
		Optional<Padawan> padawanOpt = repository.findById(id);
		if (padawanOpt.isPresent()) {
			Padawan padawan = new Padawan(padawanDTO);
			padawan.setId(id);
			repository.save(padawan);
		}
	}
}

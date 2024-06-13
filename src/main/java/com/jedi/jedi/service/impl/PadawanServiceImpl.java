package com.jedi.jedi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedi.jedi.domain.Padawan;
import com.jedi.jedi.domain.User;
import com.jedi.jedi.dto.PadawanRequestDTO;
import com.jedi.jedi.dto.PadawanResponseDTO;
import com.jedi.jedi.exceptions.RequestNotFoundException;
import com.jedi.jedi.repository.PadawanRepository;
import com.jedi.jedi.service.PadawanService;
import com.jedi.jedi.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class PadawanServiceImpl implements PadawanService{

	@Autowired
	private PadawanRepository repository;
	
	@Autowired UserService userService;
	
	@Override
	public void addPadawan(PadawanRequestDTO padawanDTO) {
		Padawan padawan = new Padawan(padawanDTO);
		User user = userService.getUserId();
		padawan.setUserId(user);
		repository.save(padawan);
	}

	@Override
	public PadawanResponseDTO getPadawan(Long id) {
		Optional<Padawan> padawanOpt = repository.findById(id);
		return padawanOpt.map(padawan -> new PadawanResponseDTO(padawan.getName(), padawan.getRace(), padawan.getPowerLevel()))
				.orElseThrow(() -> new RequestNotFoundException("Padawan de id: " + id + " não encontrado"));
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

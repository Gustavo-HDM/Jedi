package com.jedi.jedi.service;

import com.jedi.jedi.domain.Jedi;
import com.jedi.jedi.dto.JediRequestDTO;

public interface JediService {

	/**
	 * Metodo para adicionar um Jedi
	 * @return null
	 * @throws JediException
	 * @param jedi
	 */
	//public void addJedi(Jedi jedi);
	public void addJedi(JediRequestDTO jedi);
	public Jedi getJedi(Long id);
	
}

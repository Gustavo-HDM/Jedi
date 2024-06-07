package com.jedi.jedi.service;

import java.util.List;

import com.jedi.jedi.domain.Jedi;
import com.jedi.jedi.dto.JediRequestDTO;

public interface JediService {

	/**
	 * Method to add an Jedi to the database
	 * @throws JediException
	 * @param jedi
	 */
	
	public void addJedi(JediRequestDTO jedi);
	
	/**
	 * Method to bring an Jedi from the database
	 * @return jedi
	 * @throws JediNullException
	 * @param id
	 */
	public Jedi getJedi(Long id);
	
	/**
	 * Method to delete an Jedi from the database
	 * @throws JediException
	 * @param id
	 */
	public void delJedi(Long id);
	
	/**
	 * Method to alter a Jedi's data from the database
	 * @throws JediException, JediNullException
	 * @param id
	 * @param jedi
	 */
	public void uptJedi(Long id, JediRequestDTO jedi);
	
	public List<Jedi> filterPowerJedi(Integer minPower, Integer maxPower);
	
}

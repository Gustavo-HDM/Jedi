package com.jedi.jedi.service;

import com.jedi.jedi.domain.LightSaber;
import com.jedi.jedi.dto.LightSaberRequestDTO;

public interface LightSaberService {

	/**
	 * Method to add an Light Saber to the database
	 * @throws LightSaberException
	 * @param lightSaber
	 */
	public void addLightSaber(LightSaberRequestDTO lightSaberDTO);
	
	/**
	 * Method to bring an Light Saber from the database
	 * @param id
	 * @throws LightSaberNullException
	 * @return lightSaber
	 */
	public LightSaber getLightSaber(Long id);
	
	/**
	 * Method to delete an Light Saber from the database
	 * @param id
	 * @throws LightSaberException
	 */
	public void delLightSaber(Long id);
	
	/**
	 * Method to alter an LightSaber's data from the database
	 * @param id
	 * @param lightSaber
	 * @throws LightSaberException, LightSaberNullException
	 */
	public void uptLightSaber(Long id, LightSaberRequestDTO lightSaberDTO);
}

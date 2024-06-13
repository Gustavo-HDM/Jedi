package com.jedi.jedi.service;

import com.jedi.jedi.dto.PadawanRequestDTO;
import com.jedi.jedi.dto.PadawanResponseDTO;

public interface PadawanService {
	
	/**
	 * Method do add an Padawan to the database
	 * @throws PadawanException
	 * @param padawan
	 */
	public void addPadawan(PadawanRequestDTO padawanDTO);
	
	/**
	 * Method to bring an Padawan from the database
	 * @return padawan
	 * @throws PadawanNullException
	 * @param id
	 */
	public PadawanResponseDTO getPadawan(Long id);
	
	/**
	 * Method to delete an Padawan from the database
	 * @throws PadawanException
	 * @param id
	 */
	public void delPadawan(Long id);
	
	/**
	 * Method to alter a Padawan's data from the database
	 * @throws PadawanException, PadawanNullException
	 * @param id
	 * @param padawan
	 */
	public void uptPadawan(Long id, PadawanRequestDTO padawanDTO);
}

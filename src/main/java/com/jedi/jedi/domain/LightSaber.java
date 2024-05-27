package com.jedi.jedi.domain;

import com.jedi.jedi.dto.LightSaberRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Entity
@Data
@Getter
@ToString
@Table(name = "light_saber")
public class LightSaber {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id")
	private Long id;
	
	@Column(name = "color")
	public String color;
	
	@Column(name = "size")
	public Double size;
	
	public LightSaber() {
		
	}
	
	public LightSaber(LightSaberRequestDTO lightSaberDTO) {
		this.color = lightSaberDTO.color();
		this.size = lightSaberDTO.size();
	}
}

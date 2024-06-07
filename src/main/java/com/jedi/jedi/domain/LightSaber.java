package com.jedi.jedi.domain;

import com.jedi.jedi.dto.LightSaberRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	
	//@NotBlank (message = "Define the color of the light saber")
	@Column(name = "color")
	public String color;
	
	//@NotBlank (message = "Define the size of the light saber")
	@Column(name = "size")
	public Double size;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User userId;
	
	public LightSaber() {
		
	}
	
	public LightSaber(LightSaberRequestDTO lightSaberDTO) {
		this.color = lightSaberDTO.color();
		this.size = lightSaberDTO.size();
	}
}

package com.jedi.jedi.domain;

import com.jedi.jedi.dto.JediRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Entity
@Data
@Getter
@ToString
@Table(name = "jedi")
public class Jedi {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "race")
	private String race;

	@OneToOne
	@JoinColumn(name = "light_saber_id", referencedColumnName = "id")
	private LightSaber lightSaber;

	//TODO colocar planeta aqui @ManyToOne
	
	@Column(name = "power_level")
	private Integer powerLevel;

	public Jedi() {
	}

	public Jedi(JediRequestDTO jediDTO, LightSaber lightSaber) {
		this.name = jediDTO.name();
		this.race = jediDTO.race();
		this.powerLevel = jediDTO.powerLevel();
		this.lightSaber = lightSaber;
	}
	
	public Jedi(JediRequestDTO jediDTO) {
		this.name = jediDTO.name();
		this.race = jediDTO.race();
		this.powerLevel = jediDTO.powerLevel();
	}
}

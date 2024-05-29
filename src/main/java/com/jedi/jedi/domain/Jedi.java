package com.jedi.jedi.domain;

import com.jedi.jedi.dto.JediRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "jedi")
public class Jedi {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotBlank (message = "Name is obligatory")
	@Column(name = "name")
	private String name;

	@NotBlank (message = "Race is obligatory")
	@Column(name = "race")
	private String race;
	
	@Column(name = "power_level")
	private Integer powerLevel;

	@OneToOne
	@NotBlank (message = "A Jedi must have an light saber")
	@JoinColumn(name = "light_saber_id", referencedColumnName = "id")
	private LightSaber lightSaber;

	@ManyToOne
	@JoinColumn(name = "planet", referencedColumnName = "id")
	private Planet planet;

	public Jedi() {
	}
	
	public Jedi(JediRequestDTO jediDTO, LightSaber lightSaber, Planet planet) {
		this.name = jediDTO.name();
		this.race = jediDTO.race();
		this.powerLevel = jediDTO.powerLevel();
		this.lightSaber = lightSaber;
		this.planet = planet;
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

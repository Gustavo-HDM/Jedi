package com.jedi.jedi.domain;

import com.jedi.jedi.dto.PadawanRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Entity
@Data
@Getter
@ToString
@Table(name = "padawan")
public class Padawan {

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
	
	@Column(name = "power_level")
	private Integer powerLevel;

	@ManyToOne
	@JoinColumn(name = "master_jedi_id", referencedColumnName = "id")
	private Jedi jedi;
	
	public Padawan() {
		
	}
	
	public Padawan(PadawanRequestDTO padawanDTO) {
		this.name = padawanDTO.name();
		this.race = padawanDTO.race();
		this.powerLevel = padawanDTO.powerLevel();
	}
}

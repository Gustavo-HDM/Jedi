package com.jedi.jedi.domain;

import java.util.List;

import com.jedi.jedi.dto.PlanetRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Entity
@Data
@Getter
@ToString
@Table(name = "planet")
public class Planet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "population")
	private Integer pop;
	
	@OneToMany
	@JoinColumn(name = "affiliated_jedi_id", referencedColumnName = "id")
	private List<Jedi> jedi;
	
	public Planet() {
		
	}
	
	public Planet(PlanetRequestDTO planetDTO) {
		this.name = planetDTO.name();
		this.pop = planetDTO.pop();
	}
}

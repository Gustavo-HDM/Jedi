package com.jedi.jedi.domain;

import com.jedi.jedi.dto.PlanetRequestDTO;

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
@Table(name = "planet")
public class Planet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotBlank (message = "Name is obligatory")
	@Column(name = "name")
	private String name;
	
	@Column(name = "population")
	private Integer pop;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User userId;
	
//	@OneToMany
//	@JoinColumn(name = "affiliated_jedi_id", referencedColumnName = "id")
//	private List<Jedi> jedi;
	
	public Planet() {
		
	}
	
	public Planet(PlanetRequestDTO planetDTO) {
		this.name = planetDTO.name();
		this.pop = planetDTO.pop();
	}
}

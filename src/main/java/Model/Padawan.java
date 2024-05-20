package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
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
	
	@Column(name = "light_saber")
	private LightSaber lightSaber;
	
	@Column(name = "power_level")
	private Integer powerLevel;

	@Column(name = "master_jedi")
	private Jedi jedi;
}

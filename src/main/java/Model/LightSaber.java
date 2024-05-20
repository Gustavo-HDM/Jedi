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
@Table(name = "light_saber")
public class LightSaber {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id")
	private Long id;
	
	@Column(name = "color")
	public String color;
	
	@Column(name = "size")
	public double size;
}

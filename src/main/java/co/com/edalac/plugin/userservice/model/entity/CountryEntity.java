package co.com.edalac.plugin.userservice.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "country_master")
@NoArgsConstructor
public class CountryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCountry;
	private String name;
	private String code;
	
	public CountryEntity(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}	
}

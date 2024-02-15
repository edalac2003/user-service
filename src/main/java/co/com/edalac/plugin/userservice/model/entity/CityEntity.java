package co.com.edalac.plugin.userservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "city_master")
@NoArgsConstructor
@AllArgsConstructor
public class CityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_city")
	private Long idCity;
	private String name;
	private String code;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "state_id")
	private StateEntity state;
}

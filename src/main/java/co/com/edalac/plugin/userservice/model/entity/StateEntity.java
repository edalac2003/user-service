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
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Entity
@Table(name = "state_master")
@AllArgsConstructor
public class StateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_state")
	private Long idState;
	private String name;
	private String code;
	
//	@Column(name = "state_id")
//	private int stateId;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "country_id")
	private CountryEntity country;
}

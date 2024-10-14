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
@Table(name = "identification_person")
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationPersonEntity {

	@Id
	@Column(name = "id_identification_person")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
//	@JoinColumn(columnDefinition = "person_id", insertable = false, updatable = false)
	private PersonEntity person;
	
	@ManyToOne
//	@JoinColumn(columnDefinition = "identification_type_id", insertable = false, updatable = false)
	private IdentificationTypeEntity identificationType;
	
	@Column(name = "is_master")
	private Boolean master;
	
	@Column(name = "is_active")
	private Boolean active;
	
	private String value;
}

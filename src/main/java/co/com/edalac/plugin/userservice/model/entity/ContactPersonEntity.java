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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact_person")
public class ContactPersonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contact_person")
	private Long id;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "person_id")
	private PersonEntity person;
	
	@ManyToOne()
	@JoinColumn(insertable = false, updatable = false)
	private ContactTypeEntity contactType;
	
	@Column(name = "is_master")
	private Boolean master;
	
	@Column(name = "is_active")
	private Boolean active;
	
}

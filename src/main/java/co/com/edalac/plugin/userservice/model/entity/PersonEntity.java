package co.com.edalac.plugin.userservice.model.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person_master")
public class PersonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_person")
	private Long id;
	private String firstName;
	private String lastName;
	private String genre;
	private LocalDate birthdate;
	private Boolean status;
	private Long cityId;
	
	@Transient
//	@ManyToOne
//	@JoinColumn(columnDefinition = "city_id", insertable = false, updatable = false)
	private CityEntity city;
	
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(referencedColumnName = "id_person")
	@Transient
	private List<IdentificationPersonEntity> identifications;
	
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(referencedColumnName = "id_person")
	@Transient
	private List<ContactPersonEntity> contacts;
	
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(columnDefinition = "id_person")
	@Transient
	private List<AddressPersonEntity> adresses;
	
}

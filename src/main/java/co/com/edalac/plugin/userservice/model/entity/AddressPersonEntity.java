package co.com.edalac.plugin.userservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "address_person")
@AllArgsConstructor
@NoArgsConstructor
public class AddressPersonEntity {

	@Id
	@Column(name = "id_address_person")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private PersonEntity person;
	
	@ManyToOne
	private AddressTypeEntity addressType;
	private Boolean master;
	private Boolean active;
	
	@ManyToOne
	private CityEntity city;
	private String address;
	private String addressComplement;
}

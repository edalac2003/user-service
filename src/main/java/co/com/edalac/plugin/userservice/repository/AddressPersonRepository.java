package co.com.edalac.plugin.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.edalac.plugin.userservice.model.entity.AddressPersonEntity;

public interface AddressPersonRepository extends JpaRepository<AddressPersonEntity, Long> {

}

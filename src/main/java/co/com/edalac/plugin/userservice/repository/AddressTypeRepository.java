package co.com.edalac.plugin.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.edalac.plugin.userservice.model.entity.AddressTypeEntity;

public interface AddressTypeRepository extends JpaRepository<AddressTypeEntity, Integer> {

}

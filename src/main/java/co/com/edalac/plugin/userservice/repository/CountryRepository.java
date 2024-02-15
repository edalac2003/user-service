package co.com.edalac.plugin.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.edalac.plugin.userservice.model.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

}

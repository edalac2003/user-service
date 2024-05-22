package co.com.edalac.plugin.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.edalac.plugin.userservice.model.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}

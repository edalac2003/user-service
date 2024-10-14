package co.com.edalac.plugin.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.edalac.plugin.userservice.model.entity.ContactPersonEntity;

public interface ContactPersonRepository extends JpaRepository<ContactPersonEntity, Long> {

	List<ContactPersonEntity> findByPersonId(Long idPerson);
}

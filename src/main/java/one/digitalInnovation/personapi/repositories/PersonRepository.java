package one.digitalInnovation.personapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.digitalInnovation.personapi.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}

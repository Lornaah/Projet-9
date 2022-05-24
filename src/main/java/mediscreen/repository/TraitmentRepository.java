package mediscreen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mediscreen.model.Traitment;

@Repository
public interface TraitmentRepository extends JpaRepository<Traitment, Integer> {

	Optional<Traitment> findByName(String name);

}

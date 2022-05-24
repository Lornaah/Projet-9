package mediscreen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mediscreen.model.Disease;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Integer> {

	public Optional<Disease> findByName(String name);

}

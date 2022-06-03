package mediscreen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mediscreen.model.MedicalAntecedent;

@Repository
public interface MedicalAntecedentRepository extends JpaRepository<MedicalAntecedent, Integer> {

	@Query(value = "SELECT * FROM medical_antecedent WHERE patient_id = :patientId", nativeQuery = true)
	public List<MedicalAntecedent> findAllByPatientId(@Param("patientId") int patientId);
}

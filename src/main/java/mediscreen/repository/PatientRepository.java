package mediscreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mediscreen.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}

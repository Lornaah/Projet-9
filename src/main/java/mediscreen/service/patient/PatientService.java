package mediscreen.service.patient;

import java.util.List;

import mediscreen.dto.PatientDTO;
import mediscreen.model.Patient;

public interface PatientService {

	PatientDTO addPatient(PatientDTO patientDto);

	Patient getPatient(int id);

	void deletePatient(int id);

	List<PatientDTO> getAllPatients();

	PatientDTO updatePatient(int id, PatientDTO patientDTO);
}

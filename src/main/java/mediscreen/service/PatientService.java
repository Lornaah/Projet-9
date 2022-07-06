package mediscreen.service;

import java.util.List;

import mediscreen.dto.PatientDTO;

public interface PatientService {

	PatientDTO addPatient(PatientDTO patientDto);

	PatientDTO getPatient(int id);

	void deletePatient(int id);

	List<PatientDTO> getAllPatients();

	PatientDTO updatePatient(int id, PatientDTO patientDTO);

}

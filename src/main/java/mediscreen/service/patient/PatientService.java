package mediscreen.service.patient;

import java.util.List;

import mediscreen.dto.PatientDTO;

public interface PatientService {

	PatientDTO addPatient(PatientDTO patientDto);

	PatientDTO getPatient(int id);

	void deletePatient(int id);

	List<PatientDTO> getAllPatients();

	PatientDTO updatePatient(int id, PatientDTO patientDTO);

	String generateDiabetesReport(int patientId, int occurrences);
}

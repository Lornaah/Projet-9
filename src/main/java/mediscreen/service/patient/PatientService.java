package mediscreen.service.patient;

import mediscreen.dto.PatientDTO;

public interface PatientService {

	void addPatient(PatientDTO patientDto);

	PatientDTO getPerson(int id);
}

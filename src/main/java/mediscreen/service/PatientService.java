package mediscreen.service;

import mediscreen.dto.PatientDTO;

public interface PatientService {

	void addPerson(PatientDTO patientDto);

	PatientDTO getPerson(int id);
}

package mediscreen.service.patient;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mediscreen.dto.PatientDTO;
import mediscreen.model.Patient;
import mediscreen.repository.PatientRepository;
import mediscreen.service.patienthistory.PatientHistoryService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientHistoryService patientHistoryService;

	@Override
	public void addPatient(PatientDTO patientDto) {
		Patient patient = new Patient(patientDto);
		patient.setPatientHistory(patientHistoryService.addPatientHistory(patient));
		patientRepository.save(patient);
	}

	@Override
	public Patient getPatient(int id) {
		Optional<Patient> patient = patientRepository.findById(id);
		if (patient.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found" + id);
		return patient.get();
	}

	@Override
	public void deletePatient(int id) {
		Patient patient = getPatient(id);
		patientRepository.delete(patient);
	}
}

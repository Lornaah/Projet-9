package mediscreen.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public PatientDTO getPerson(int id) {
		return new PatientDTO(patientRepository.getReferenceById(id));
	}
}

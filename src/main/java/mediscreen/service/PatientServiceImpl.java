package mediscreen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mediscreen.dto.PatientDTO;
import mediscreen.model.Patient;
import mediscreen.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public void addPerson(PatientDTO patientDto) {
		Patient patient = new Patient(patientDto);
		patientRepository.save(patient);
	}

	@Override
	public PatientDTO getPerson(int id) {
		return new PatientDTO(patientRepository.getReferenceById(id));
	}
}

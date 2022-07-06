package mediscreen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mediscreen.dto.PatientDTO;
import mediscreen.model.Patient;
import mediscreen.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public PatientDTO addPatient(PatientDTO patientDto) {
		Patient patient = new Patient(patientDto);
		return new PatientDTO(patientRepository.save(patient));
	}

	@Override
	public PatientDTO getPatient(int id) {
		Optional<Patient> patient = patientRepository.findById(id);
		if (!patient.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found" + id);
		return new PatientDTO(patient.get());
	}

	@Override
	public List<PatientDTO> getAllPatients() {
		List<Patient> patients = patientRepository.findAll();
		List<PatientDTO> patientsDTOList = new ArrayList<>();
		patients.forEach(p -> {
			PatientDTO patient = new PatientDTO(p);
			patientsDTOList.add(patient);
		});
		return patientsDTOList;
	}

	@Override
	@Transactional
	public PatientDTO updatePatient(int id, PatientDTO patientDTO) {
		Patient patient = new Patient(getPatient(id));
		Patient newPatient = new Patient(patientDTO);
		newPatient.setId(patient.getId());
		return new PatientDTO(patientRepository.save(newPatient));
	}

	@Override
	public void deletePatient(int id) {
		patientRepository.deleteById(id);
	}

}

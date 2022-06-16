package mediscreen.service.patient;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mediscreen.dto.PatientDTO;
import mediscreen.model.Gender;
import mediscreen.model.Patient;
import mediscreen.repository.PatientRepository;
import mediscreen.service.patient_history.PatientHistoryService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientHistoryService patientHistoryService;

	@Override
	public PatientDTO addPatient(PatientDTO patientDto) {
		Patient patient = new Patient(patientDto);
		patient.setPatientHistory(patientHistoryService.addPatientHistory(patient));
		return new PatientDTO(patientRepository.save(patient));

	}

	@Override
	public PatientDTO getPatient(int id) {
		Optional<Patient> patient = patientRepository.findById(id);
		if (patient.isEmpty())
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
		Patient patient = new Patient(getPatient(id));
		patientHistoryService.deletePatientHistory(id);
		patientRepository.delete(patient);
	}

	private int getPatientAge(Patient patient) {
		Date birthdate = patient.getBirthDate();

		LocalDate localDate = LocalDate.now();
		LocalDate birthLocalDate = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		long differenceBetween = ChronoUnit.YEARS.between(birthLocalDate, localDate);
		int age = Math.toIntExact(differenceBetween);
		return age;
	}

	@Override
	public String generateDiabetesReport(int patientId, int occurrences) {
		Patient patient = new Patient(getPatient(patientId));
		int age = getPatientAge(patient);

		if (age > 30) {
			if (occurrences >= 2 && occurrences < 6)
				return "Bordeline";
			if (occurrences >= 6 && occurrences < 8)
				return "In Danger";
			if (occurrences >= 8)
				return "Early onset";
		}

		if (age < 30) {
			if (patient.getGender().equals(Gender.FEMALE)) {
				if (occurrences == 4) {
					return "In Danger";
				} else if (occurrences == 7) {
					return "Early onset";
				}
			} else if (patient.getGender().equals(Gender.MALE)) {
				if (occurrences == 3) {
					return "In Danger";
				} else if (occurrences == 5) {
					return "Early onset";
				}
			}
		}
		return "None";
	}

}

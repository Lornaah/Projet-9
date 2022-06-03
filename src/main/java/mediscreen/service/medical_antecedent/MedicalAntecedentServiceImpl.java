package mediscreen.service.medical_antecedent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mediscreen.dto.MedicalAntecedentDTO;
import mediscreen.model.MedicalAntecedent;
import mediscreen.model.Patient;
import mediscreen.repository.MedicalAntecedentRepository;
import mediscreen.service.patient.PatientService;

@Service
public class MedicalAntecedentServiceImpl implements MedicalAntecedentService {

	@Autowired
	MedicalAntecedentRepository antecedentRepository;

	@Autowired
	PatientService patientService;

	@Override
	public MedicalAntecedent getMedicalAntecedent(int id) {
		Optional<MedicalAntecedent> antecedent = antecedentRepository.findById(id);
		if (antecedent.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Antecedent with id : " + id + " not found ");
		}
		return antecedent.get();
	}

	@Override
	public List<MedicalAntecedentDTO> getAllMedicalAntecedents(int id) {
		List<MedicalAntecedent> medicalAntList = antecedentRepository.findAllByPatientId(id);
		List<MedicalAntecedentDTO> antecedentDTOs = new ArrayList<>();
		medicalAntList.forEach(m -> {
			MedicalAntecedentDTO antecedentDTO = new MedicalAntecedentDTO(m);
			antecedentDTOs.add(antecedentDTO);
		});
		return antecedentDTOs;
	}

	@Override
	public void addMedicalAntecedent(int id, @Valid MedicalAntecedentDTO medicalAntecedentDTO) {
		Patient patient = patientService.getPatient(id);
		MedicalAntecedent antecedent = new MedicalAntecedent(medicalAntecedentDTO);
		antecedent.setPatientHistory(patient.getPatientHistory());
		antecedentRepository.save(antecedent);
	}

	@Override
	public void deleteMedicalAntecedent(int id) {
		Optional<MedicalAntecedent> antecedent = antecedentRepository.findById(id);
		if (antecedent.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Traitment with id " + id + " not found");
		antecedentRepository.delete(antecedent.get());
	}

}

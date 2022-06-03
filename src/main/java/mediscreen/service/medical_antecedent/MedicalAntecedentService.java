package mediscreen.service.medical_antecedent;

import java.util.List;

import javax.validation.Valid;

import mediscreen.dto.MedicalAntecedentDTO;
import mediscreen.model.MedicalAntecedent;

public interface MedicalAntecedentService {

	MedicalAntecedent getMedicalAntecedent(int id);

	List<MedicalAntecedentDTO> getAllMedicalAntecedents(int id);

	void addMedicalAntecedent(int id, @Valid MedicalAntecedentDTO medicalAntecedentDTO);

	void deleteMedicalAntecedent(int id);

}

package mediscreen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mediscreen.dto.MedicalAntecedentDTO;
import mediscreen.service.medical_antecedent.MedicalAntecedentService;

@RestController
public class MedicalAntecedentController {

	@Autowired
	MedicalAntecedentService medicalAntecedentService;

	@GetMapping("/patient/{id}/medicalAntecedent/get/{identifiant}")
	public MedicalAntecedentDTO getMedicalAntecedent(@PathVariable int id) {
		return new MedicalAntecedentDTO(medicalAntecedentService.getMedicalAntecedent(id));
	}

	@GetMapping("/patient/{id}/getAllMedicalAntecedents")
	public List<MedicalAntecedentDTO> getAllMedicalAntecedents(@PathVariable int id) {
		return medicalAntecedentService.getAllMedicalAntecedents(id);
	}

	@PostMapping("/patient/{id}/medicalAntecedent/add")
	public String addMedicalAntecedent(@RequestParam int id,
			@RequestBody @Valid MedicalAntecedentDTO medicalAntecedentDTO) {
		medicalAntecedentService.addMedicalAntecedent(id, medicalAntecedentDTO);
		return medicalAntecedentDTO.getDisease() + " added";
	}

	@DeleteMapping("/patient/{id}/medicalAntecedent/delete/{identifiant}")
	public void deleteMedicalAntecedent(@PathVariable int id, @PathVariable int identifiant) {
		medicalAntecedentService.deleteMedicalAntecedent(id);
	}
}

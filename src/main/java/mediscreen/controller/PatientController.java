package mediscreen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mediscreen.dto.PatientDTO;
import mediscreen.service.patient.PatientService;

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;

	@PostMapping("/patient/add")
	public String addPatient(@RequestBody @Valid PatientDTO patientDTO) {
		patientService.addPatient(patientDTO);
		return patientDTO.getFamily() + " " + patientDTO.getGiven() + " added";
	}

	@CrossOrigin
	@GetMapping("/patient/get")
	public PatientDTO getPatient(@RequestParam int id) {
		return new PatientDTO(patientService.getPatient(id));
	}

	@CrossOrigin
	@GetMapping("/patients")
	public List<PatientDTO> getAllPatients() {
		return patientService.getAllPatients();
	}

	@DeleteMapping("/patient/delete")
	public void deletePatient(@RequestParam int id) {
		patientService.deletePatient(id);
	}

}

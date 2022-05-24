package mediscreen.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mediscreen.dto.PatientDTO;
import mediscreen.service.patient.PatientService;

@RestController
public class MediscreenController {

	@Autowired
	PatientService patientService;

	@PostMapping("/patient/add")
	public String addPatient(@RequestBody @Valid PatientDTO patientDTO) {
		patientService.addPatient(patientDTO);
		return patientDTO.getFamily() + " " + patientDTO.getGiven() + " added";
	}

	@GetMapping("/getPatient/{id}")
	public PatientDTO getPatient(@RequestParam int id) {
		return patientService.getPerson(id);

	}

	@GetMapping("/patient/test")
	public String test() {
		return "test";
	}

}

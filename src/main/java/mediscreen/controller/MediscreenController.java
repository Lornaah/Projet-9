package mediscreen.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mediscreen.dto.PatientDTO;
import mediscreen.service.PatientService;

@RestController
public class MediscreenController {

	@Autowired
	PatientService patientService;

	@PostMapping("/patient/add")
	public String addPerson(@RequestBody @Valid PatientDTO patient, Model model) {
		patientService.addPerson(patient);
		return patient.getFamily() + " added";
	}

	@GetMapping("/patient/test")
	public String test() {
		return "test";
	}

}

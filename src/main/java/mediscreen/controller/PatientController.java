package mediscreen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mediscreen.dto.PatientDTO;
import mediscreen.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;

	@CrossOrigin
	@PostMapping("/patient/add")
	public PatientDTO addPatient(@RequestBody @Valid PatientDTO patientDTO) {
		return patientService.addPatient(patientDTO);
	}

	@CrossOrigin
	@GetMapping("/patient/get")
	public PatientDTO getPatient(@RequestParam int id) {
		return patientService.getPatient(id);
	}

	@CrossOrigin
	@GetMapping("/patients")
	public List<PatientDTO> getAllPatients() {
		return patientService.getAllPatients();
	}

	@CrossOrigin
	@PutMapping("/patient/update")
	public PatientDTO updatePatient(@RequestParam int id, @RequestBody @Valid PatientDTO patientDTO) {
		return patientService.updatePatient(id, patientDTO);
	}

	@CrossOrigin
	@DeleteMapping("/patient/delete")
	public void deletePatient(@RequestParam int id) {
		patientService.deletePatient(id);
	}

}

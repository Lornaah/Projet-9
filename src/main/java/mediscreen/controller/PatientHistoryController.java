package mediscreen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import mediscreen.dto.PatientHistoryDTO;
import mediscreen.service.patient_history.PatientHistoryService;

@RestController
public class PatientHistoryController {

	@Autowired
	PatientHistoryService patientHistoryService;

	@CrossOrigin
	@GetMapping("/patient/{id}/patientHistory/get")
	public PatientHistoryDTO getPatientHistory(@PathVariable int id) {
		return new PatientHistoryDTO(patientHistoryService.getPatientHistory(id));
	}

}

package mediscreen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mediscreen.dto.PatientHistoryDTO;
import mediscreen.service.patient_history.PatientHistoryService;

@RestController
public class PatientHistoryController {

	@Autowired
	PatientHistoryService patientHistoryService;

	@GetMapping("/patient/{id}/patientHistory/get")
	public PatientHistoryDTO getPatientHistory(@PathVariable int id) {
		return new PatientHistoryDTO(patientHistoryService.getPatientHistory(id));
	}

	@PostMapping("/patient/{id}/patientHistory/setNote")
	public void addNote(@PathVariable int id, @RequestParam String note) {
		patientHistoryService.setNote(id, note);
	}

	@DeleteMapping("/patient/{id}/patientHistory/deleteNote")
	public void deleteNote(@PathVariable int id) {
		patientHistoryService.deleteNote(id);
	}

}

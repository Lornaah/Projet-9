package mediscreen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mediscreen.dto.PatientHistoryDTO;
import mediscreen.service.patienthistory.PatientHistoryService;

@RestController
public class PatientHistoryController {

	@Autowired
	PatientHistoryService patientHistoryService;

	@GetMapping("/getPatientHistory")
	public PatientHistoryDTO getPatientHistory(@RequestParam int id) {
		return new PatientHistoryDTO(patientHistoryService.getPatientHistory(id));
	}

	@PostMapping("/patientHistory/setNote")
	public void addNote(@RequestParam int id, @RequestParam String note) {
		patientHistoryService.setNote(id, note);
	}

	@DeleteMapping("/patientHistory/deleteNote")
	public void deleteNote(@RequestParam int id) {
		patientHistoryService.deleteNote(id);
	}

}

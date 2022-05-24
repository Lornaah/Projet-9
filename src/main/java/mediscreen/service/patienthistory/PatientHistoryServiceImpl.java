package mediscreen.service.patienthistory;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mediscreen.model.Patient;
import mediscreen.model.PatientHistory;
import mediscreen.repository.PatientHistoryRepository;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService {

	@Autowired
	PatientHistoryRepository patientHistoryRepository;

	@Override
	public PatientHistory addPatientHistory(Patient patient) {

		PatientHistory patientHistory = new PatientHistory();
		patientHistory.setPatient(patient);
		return patientHistoryRepository.save(patientHistory);
	}

	@Override
	public void setNote(int id, String note) {
		PatientHistory patientHistory = getPatientHistory(id);
		patientHistory.setNote(note);
		patientHistoryRepository.save(patientHistory);
	}

	@Override
	public PatientHistory getPatientHistory(int id) {
		Optional<PatientHistory> patientHistory = patientHistoryRepository.findById(id);
		if (patientHistory.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient History not found " + id);
		return patientHistory.get();

	}

	@Override
	public void deleteNote(int id) {
		PatientHistory patientHistory = getPatientHistory(id);
		patientHistory.setNote("");
		patientHistoryRepository.save(patientHistory);
	}

}

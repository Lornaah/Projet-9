package mediscreen.service.patienthistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

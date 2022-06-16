package mediscreen.service.patient_history;

import mediscreen.model.Patient;
import mediscreen.model.PatientHistory;

public interface PatientHistoryService {

	public PatientHistory addPatientHistory(Patient patient);

	public PatientHistory getPatientHistory(int id);

	public void deletePatientHistory(int id);

}

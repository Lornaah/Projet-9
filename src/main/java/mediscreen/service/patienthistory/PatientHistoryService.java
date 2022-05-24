package mediscreen.service.patienthistory;

import mediscreen.model.Patient;
import mediscreen.model.PatientHistory;

public interface PatientHistoryService {

	public PatientHistory addPatientHistory(Patient patient);

	public PatientHistory getPatientHistory(int id);

	public void setNote(int id, String note);

	public void deleteNote(int id);

}

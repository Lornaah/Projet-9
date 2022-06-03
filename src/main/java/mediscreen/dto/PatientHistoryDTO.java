package mediscreen.dto;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import mediscreen.model.MedicalAntecedent;
import mediscreen.model.PatientHistory;

public class PatientHistoryDTO {

	@NotNull
	private List<MedicalAntecedent> medicalHistories;
	private String note;

	public PatientHistoryDTO() {
	}

	public PatientHistoryDTO(@NotNull List<MedicalAntecedent> medicalHistories, String note) {
		this.medicalHistories = medicalHistories;
		this.note = note;
	}

	public PatientHistoryDTO(PatientHistory patientHistory) {
		this.medicalHistories = patientHistory.getMedicalAntecedents();
		this.note = patientHistory.getNote();
	}

	public List<MedicalAntecedent> getMedicalAntecedents() {
		return medicalHistories;
	}

	public void setMedicalHistories(List<MedicalAntecedent> medicalHistories) {
		this.medicalHistories = medicalHistories;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		return Objects.hash(medicalHistories, note);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientHistoryDTO other = (PatientHistoryDTO) obj;
		return Objects.equals(medicalHistories, other.medicalHistories) && Objects.equals(note, other.note);
	}

	@Override
	public String toString() {
		return "PatientHistoryDTO [medicalHistories=" + medicalHistories + ", note=" + note + "]";
	}

}

package mediscreen.dto;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import mediscreen.model.MedicalAntecedent;
import mediscreen.model.PatientHistory;

public class PatientHistoryDTO {

	@NotNull
	private List<MedicalAntecedent> medicalHistories;

	public PatientHistoryDTO() {
	}

	public PatientHistoryDTO(@NotNull List<MedicalAntecedent> medicalHistories, String note) {
		this.medicalHistories = medicalHistories;
	}

	public PatientHistoryDTO(PatientHistory patientHistory) {
		this.medicalHistories = patientHistory.getMedicalAntecedents();
	}

	public List<MedicalAntecedent> getMedicalAntecedents() {
		return medicalHistories;
	}

	public void setMedicalHistories(List<MedicalAntecedent> medicalHistories) {
		this.medicalHistories = medicalHistories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(medicalHistories);
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
		return Objects.equals(medicalHistories, other.medicalHistories);
	}

	@Override
	public String toString() {
		return "PatientHistoryDTO [medicalHistories=" + medicalHistories + "]";
	}

}

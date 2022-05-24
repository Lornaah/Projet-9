package mediscreen.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import mediscreen.dto.PatientHistoryDTO;

@Entity
@Table(name = "PatientHistory")
public class PatientHistory {

	@Id
	private int id;

	@OneToMany
	@PrimaryKeyJoinColumn
	private List<MedicalHistory> medicalHistories;

	private String note;

	@OneToOne
	@MapsId
	private Patient patient;

	public PatientHistory() {
	}

	public PatientHistory(PatientHistoryDTO patientDTO) {
		this.medicalHistories = patientDTO.getMedicalHistories();
		this.note = patientDTO.getNote();
	}

	public PatientHistory(int id, List<MedicalHistory> medicalHistories, String note) {
		this.id = id;
		this.medicalHistories = medicalHistories;
		this.note = note;
	}

	public PatientHistory(List<MedicalHistory> medicalHistories, String note) {
		this.medicalHistories = medicalHistories;
		this.note = note;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<MedicalHistory> getMedicalHistories() {
		return medicalHistories;
	}

	public void setMedicalHistories(List<MedicalHistory> medicalHistories) {
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
		return Objects.hash(id, medicalHistories, note);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientHistory other = (PatientHistory) obj;
		return id == other.id && Objects.equals(medicalHistories, other.medicalHistories)
				&& Objects.equals(note, other.note);
	}

	@Override
	public String toString() {
		return "PatientHistory [id=" + id + ", medicalHistories=" + medicalHistories + ", note=" + note + "]";
	}

}

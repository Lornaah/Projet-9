package mediscreen.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import mediscreen.dto.PatientHistoryDTO;

@Entity
@Table(name = "PatientHistory")
public class PatientHistory {

	@Id
	private int id;

	@OneToMany(mappedBy = "patientHistory", cascade = CascadeType.ALL)
	private List<MedicalAntecedent> medicalAntecedents;

	@OneToOne
	@MapsId
	private Patient patient;

	public PatientHistory() {
	}

	public PatientHistory(PatientHistoryDTO patientDTO) {
		this.medicalAntecedents = patientDTO.getMedicalAntecedents();
	}

	public PatientHistory(int id, List<MedicalAntecedent> medicalAntecedents, String note) {
		this.id = id;
		this.medicalAntecedents = medicalAntecedents;
	}

	public PatientHistory(List<MedicalAntecedent> medicalAntecedents, String note) {
		this.medicalAntecedents = medicalAntecedents;
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

	public List<MedicalAntecedent> getMedicalAntecedents() {
		return medicalAntecedents;
	}

	public void setMedicalAntecedents(List<MedicalAntecedent> medicalAntecedents) {
		this.medicalAntecedents = medicalAntecedents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, medicalAntecedents, patient);
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
		return id == other.id && Objects.equals(medicalAntecedents, other.medicalAntecedents)
				&& Objects.equals(patient, other.patient);
	}

	@Override
	public String toString() {
		return "PatientHistory [id=" + id + ", medicalAntecedents=" + medicalAntecedents + ", patient=" + patient + "]";
	}

}

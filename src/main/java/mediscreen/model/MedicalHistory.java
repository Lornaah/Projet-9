package mediscreen.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MedicalHistory")
public class MedicalHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	private Disease disease;

	@OneToMany
	private List<Traitment> traitments;

	@ManyToOne
	@MapsId
	private PatientHistory patientHistory;

	public MedicalHistory() {
	}

	public MedicalHistory(Disease disease, List<Traitment> traitments) {
		this.disease = disease;
		this.traitments = traitments;
	}

	public MedicalHistory(int id, Disease disease, List<Traitment> traitments) {
		this.id = id;
		this.disease = disease;
		this.traitments = traitments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public List<Traitment> getTraitments() {
		return traitments;
	}

	public void setTraitments(List<Traitment> traitments) {
		this.traitments = traitments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(disease, id, traitments);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalHistory other = (MedicalHistory) obj;
		return Objects.equals(disease, other.disease) && id == other.id && Objects.equals(traitments, other.traitments);
	}

	@Override
	public String toString() {
		return "MedicalHistory [id=" + id + ", disease=" + disease + ", traitments=" + traitments + "]";
	}

}

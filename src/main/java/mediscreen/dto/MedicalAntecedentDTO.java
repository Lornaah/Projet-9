package mediscreen.dto;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import mediscreen.model.Disease;
import mediscreen.model.MedicalAntecedent;
import mediscreen.model.Traitment;

public class MedicalAntecedentDTO {

	@NotNull
	private Disease disease;

	private List<Traitment> traitments;

	public MedicalAntecedentDTO() {
	}

	public MedicalAntecedentDTO(@NotNull Disease disease, List<Traitment> traitments) {
		this.disease = disease;
		this.traitments = traitments;
	}

	public MedicalAntecedentDTO(MedicalAntecedent medicalAntecedent) {
		this.disease = medicalAntecedent.getDisease();
		this.traitments = medicalAntecedent.getTraitments();
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
		return Objects.hash(disease, traitments);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalAntecedentDTO other = (MedicalAntecedentDTO) obj;
		return Objects.equals(disease, other.disease) && Objects.equals(traitments, other.traitments);
	}

	@Override
	public String toString() {
		return "MedicalAntecedentDTO [disease=" + disease + ", traitments=" + traitments + "]";
	}

}

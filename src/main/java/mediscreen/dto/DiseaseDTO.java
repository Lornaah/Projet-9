package mediscreen.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import mediscreen.model.Disease;

public class DiseaseDTO {

	@NotNull
	private String name;

	public DiseaseDTO() {
	}

	public DiseaseDTO(String name) {
		this.name = name;
	}

	public DiseaseDTO(Disease disease) {
		this.name = disease.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiseaseDTO other = (DiseaseDTO) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "DiseaseDTO [name=" + name + "]";
	}

}

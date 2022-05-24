package mediscreen.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import mediscreen.model.Traitment;

public class TraitmentDTO {

	@NotNull
	private String name;

	@NotNull
	private String posology;

	public TraitmentDTO() {
	}

	public TraitmentDTO(@NotNull String name, @NotNull String posology) {
		this.name = name;
		this.posology = posology;
	}

	public TraitmentDTO(Traitment traitment) {
		this.name = traitment.getName();
		this.posology = traitment.getPosology();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosology() {
		return posology;
	}

	public void setPosology(String posology) {
		this.posology = posology;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, posology);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TraitmentDTO other = (TraitmentDTO) obj;
		return Objects.equals(name, other.name) && Objects.equals(posology, other.posology);
	}

	@Override
	public String toString() {
		return "TraitmentDTO [name=" + name + ", posology=" + posology + "]";
	}

}

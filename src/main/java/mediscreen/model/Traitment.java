package mediscreen.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import mediscreen.dto.TraitmentDTO;

@Entity
public class Traitment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true)
	private String name;
	private String posology;

	public Traitment() {
	}

	public Traitment(int id, String name, String posology) {
		this.id = id;
		this.name = name;
		this.posology = posology;
	}

	public Traitment(String name, String posology) {
		this.name = name;
		this.posology = posology;
	}

	public Traitment(TraitmentDTO traitmentDTO) {
		this.name = traitmentDTO.getName();
		this.posology = traitmentDTO.getPosology();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return Objects.hash(id, name, posology);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Traitment other = (Traitment) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(posology, other.posology);
	}

	@Override
	public String toString() {
		return "Traitment [id=" + id + ", name=" + name + ", posology=" + posology + "]";
	}

}

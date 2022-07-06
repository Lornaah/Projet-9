package mediscreen.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mediscreen.dto.PatientDTO;

@Entity
@Table(name = "Patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String lastName;
	private String firstName;
	private Date birthDate;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String address;
	private String phoneNumber;

	public Patient() {
	}

	public Patient(int id, String lastName, String firstName, Date birthDate, Gender gender, String address,
			String phoneNumber) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Patient(PatientDTO patientDTO) {
		this.id = patientDTO.getId();
		this.lastName = patientDTO.getFamily();
		this.firstName = patientDTO.getGiven();
		this.birthDate = patientDTO.getDob();
		this.gender = Gender.fromAbbreviation(patientDTO.getSex());
		this.address = patientDTO.getAddress();
		this.phoneNumber = patientDTO.getPhone();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, birthDate, firstName, gender, id, lastName, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(address, other.address) && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(firstName, other.firstName) && gender == other.gender && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phoneNumber, other.phoneNumber);
	}

}

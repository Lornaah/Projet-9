package mediscreen.model;

import java.util.Arrays;

public enum Gender {

	MALE("Male", "M"), FEMALE("Female", "F"), UNDEFINED("Undefined", "N/A");

	private String name;
	private String abbreviation;

	private Gender(String name, String abbreviation) {
		this.name = name;
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public static Gender fromAbbreviation(String sex) {
		return Arrays.stream(values()).filter(g -> sex.equals(g.abbreviation)).findFirst().orElse(UNDEFINED);
	}

}

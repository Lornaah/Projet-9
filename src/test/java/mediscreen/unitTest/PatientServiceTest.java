package mediscreen.unitTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import mediscreen.repository.PatientRepository;
import mediscreen.service.patient.PatientService;

public class PatientServiceTest {

	@Autowired
	PatientService patientService;

	@Autowired
	PatientRepository patientRepository;

	@Test
	public void addPatientTest() {

	}
}

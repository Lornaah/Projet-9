package mediscreen;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mediscreen.dto.PatientDTO;
import mediscreen.model.Patient;
import mediscreen.repository.PatientRepository;
import mediscreen.service.PatientService;

@SpringBootTest
public class ServicesTest {

	@Autowired
	PatientService service;

	@Autowired
	PatientRepository repository;

	@Autowired
	ClearDB clearDB;

	@BeforeEach
	public void clearDB() {
		clearDB.clearDB();
	}

	@Test
	public void addPatient() {
		PatientDTO patientDTO = new PatientDTO("family", "given", new Date(), "M", "address", "phone", 1);

		PatientDTO patientSaved = service.addPatient(patientDTO);
		List<Patient> patientList = repository.findAll();

		assertFalse(patientList.isEmpty());
		assertTrue(repository.findById(patientSaved.getId()).isPresent());
	}

	@Test
	public void getPatient() {
		PatientDTO patientDTO = new PatientDTO("family", "given", new Date(), "M", "address", "phone", 1);
		PatientDTO patientSaved = service.addPatient(patientDTO);

		PatientDTO patientFound = service.getPatient(patientSaved.getId());

		assertTrue(patientSaved.getId() == patientFound.getId());
		assertNotNull(patientFound);

	}

	@Test
	public void getAllPatients() {
		PatientDTO patientDTO = new PatientDTO("family", "given", new Date(), "M", "address", "phone", 1);
		PatientDTO patientSaved = service.addPatient(patientDTO);
		PatientDTO otherPatientDTO = new PatientDTO("family", "given", new Date(), "M", "address", "phone", 2);
		PatientDTO otherPatientSaved = service.addPatient(otherPatientDTO);

		List<PatientDTO> patientList = service.getAllPatients();

		assertFalse(patientList.isEmpty());
		assertTrue(patientList.contains(otherPatientSaved));
		assertTrue(patientList.contains(patientSaved));

	}

	@Test
	public void updatePatient() {
		PatientDTO patientDTO = new PatientDTO("family", "given", new Date(), "M", "address", "phone", 1);
		PatientDTO patientSaved = service.addPatient(patientDTO);
		PatientDTO newPatientDTO = new PatientDTO("newfamily", "newgiven", new Date(), "M", "address", "phone", 1);

		PatientDTO patientUpdated = service.updatePatient(patientSaved.getId(), newPatientDTO);

		assertTrue(patientUpdated.getId() == patientSaved.getId());
		assertTrue(newPatientDTO.getFamily().equals(patientUpdated.getFamily()));
		assertTrue(newPatientDTO.getGiven().equals(patientUpdated.getGiven()));

	}

	@Test
	public void deletePatient() {
		PatientDTO patientDTO = new PatientDTO("family", "given", new Date(), "M", "address", "phone", 1);
		PatientDTO patientSaved = service.addPatient(patientDTO);

		service.deletePatient(patientSaved.getId());
		List<PatientDTO> patientList = service.getAllPatients();

		assertTrue(patientList.isEmpty());

	}

}

package mediscreen;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mediscreen.dto.PatientDTO;
import mediscreen.model.Patient;
import mediscreen.repository.PatientRepository;
import mediscreen.service.PatientService;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

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
	public void addPatientTest() throws JsonProcessingException, Exception {
		PatientDTO patientDTO = new PatientDTO("family", "given", new Date(), "M", "address", "phone", 1);

		MvcResult result = mockMvc.perform(post("/patient/add").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(patientDTO))).andExpect(status().isOk()).andReturn();

		PatientDTO patientDTOresult = objectMapper.readValue(result.getResponse().getContentAsString(),
				PatientDTO.class);

		Optional<Patient> patient = repository.findById(patientDTOresult.getId());

		assertTrue(patient.isPresent());
	}

	@Test
	public void getPatientTest() throws JsonProcessingException, Exception {

		PatientDTO patientDTO = new PatientDTO("family", "given", new Date(), "M", "address", "phone", 1);
		PatientDTO patientDTOcreated = service.addPatient(patientDTO);

		MvcResult result = mockMvc.perform(get("/patient/get").contentType(MediaType.APPLICATION_JSON).param("id",
				String.valueOf(patientDTOcreated.getId()))).andExpect(status().isOk()).andReturn();

		PatientDTO patientDTOresult = objectMapper.readValue(result.getResponse().getContentAsString(),
				PatientDTO.class);

		assertTrue(patientDTOcreated.equals(patientDTOresult));

	}

	@Test
	public void getAllPatientsTest() throws Exception {
		PatientDTO patientDTO = new PatientDTO("family", "given", new Date(), "M", "address", "phone", 1);
		PatientDTO otherPatientDTO = new PatientDTO("family", "given", new Date(), "M", "address", "phone", 2);
		service.addPatient(patientDTO);
		service.addPatient(otherPatientDTO);

		MvcResult result = mockMvc.perform(get("/patients")).andExpect(status().isOk()).andReturn();
		List<PatientDTO> patientDTOresult = objectMapper.readValue(result.getResponse().getContentAsString(),
				List.class);

		assertFalse(patientDTOresult.isEmpty());
		assertTrue(patientDTOresult.size() == 2);
	}

	@Test
	public void patientUpdateTest() throws Exception {
		PatientDTO patientDTO = new PatientDTO("family", "given", new Date(), "M", "address", "phone", 1);
		PatientDTO patientDTOcreated = service.addPatient(patientDTO);

		PatientDTO newPatientDTO = new PatientDTO("newfamily", "newgiven", new Date(), "M", "address", "phone",
				patientDTOcreated.getId());

		MvcResult result = mockMvc
				.perform(put("/patient/update").contentType(MediaType.APPLICATION_JSON)
						.param("id", String.valueOf(patientDTOcreated.getId()))
						.content(objectMapper.writeValueAsString(newPatientDTO)))
				.andExpect(status().isOk()).andReturn();

		PatientDTO patientDTOresult = objectMapper.readValue(result.getResponse().getContentAsString(),
				PatientDTO.class);

		assertTrue(patientDTOresult.getFamily().equals(newPatientDTO.getFamily()));
		assertTrue(patientDTOresult.getGiven().equals(newPatientDTO.getGiven()));

	}

}

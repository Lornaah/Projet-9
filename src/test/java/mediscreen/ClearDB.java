package mediscreen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mediscreen.repository.PatientRepository;

@Service
public class ClearDB {

	@Autowired
	PatientRepository repo;

	public void clearDB() {
		repo.deleteAll();
	}

}

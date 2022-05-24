package mediscreen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mediscreen.dto.DiseaseDTO;
import mediscreen.service.disease.DiseaseService;

@RestController
public class DiseaseController {

	@Autowired
	DiseaseService diseaseService;

	@GetMapping("/getAllDiseases")
	public List<DiseaseDTO> getAllDiseases() {
		return diseaseService.getAllDiseases();
	}

	@GetMapping("/getDisease")
	public DiseaseDTO getDisease(@RequestParam int id) {
		return diseaseService.getDisease(id);
	}

	@PostMapping("/addDisease")
	public void addDisease(@RequestParam String disease) {
		diseaseService.addDisease(disease);
	}

	@DeleteMapping("deleteDisease")
	public void deleteDisease(@RequestParam int id) {
		diseaseService.deleteDisease(id);
	}

}

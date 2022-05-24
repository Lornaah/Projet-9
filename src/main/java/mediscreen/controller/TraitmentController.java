package mediscreen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mediscreen.dto.TraitmentDTO;
import mediscreen.service.traitment.TraitmentService;

@RestController
public class TraitmentController {

	@Autowired
	TraitmentService traitmentService;

	@GetMapping("/getAllTraitments")
	public List<TraitmentDTO> getAllTraitments() {
		return traitmentService.getAllTraitments();
	}

	@GetMapping("/getTraitment")
	public TraitmentDTO getTraitment(@RequestParam int id) {
		return traitmentService.getTraitment(id);
	}

	@PostMapping("/addTraitment")
	public String addTraitment(@RequestBody @Valid TraitmentDTO traitmentDTO) {
		traitmentService.addTraitment(traitmentDTO);
		return traitmentDTO.getName() + " added";
	}

	@DeleteMapping("/deleteTraitment")
	public void deleteTraitment(@RequestParam int id) {
		traitmentService.deleteTraitment(id);
	}
}

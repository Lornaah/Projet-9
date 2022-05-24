package mediscreen.service.traitment;

import java.util.List;

import mediscreen.dto.TraitmentDTO;

public interface TraitmentService {

	List<TraitmentDTO> getAllTraitments();

	TraitmentDTO getTraitment(int id);

	void addTraitment(TraitmentDTO traitmentDTO);

	void deleteTraitment(int id);

}

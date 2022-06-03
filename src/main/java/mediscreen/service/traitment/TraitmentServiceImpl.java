package mediscreen.service.traitment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mediscreen.dto.TraitmentDTO;
import mediscreen.model.Traitment;
import mediscreen.repository.TraitmentRepository;

@Service
public class TraitmentServiceImpl implements TraitmentService {

	@Autowired
	TraitmentRepository traitmentRepository;

	@Override
	public List<TraitmentDTO> getAllTraitments() {
		List<Traitment> traitments = traitmentRepository.findAll();
		List<TraitmentDTO> traitmentsDTOList = new ArrayList<>();
		traitments.forEach(t -> {
			TraitmentDTO traitmentDTO = new TraitmentDTO(t);
			traitmentsDTOList.add(traitmentDTO);
		});
		return traitmentsDTOList;
	}

	@Override
	public TraitmentDTO getTraitment(int id) {
		if (traitmentRepository.findById(id).isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Traitment with id : " + id + " not found ");
		return new TraitmentDTO(traitmentRepository.findById(id).get());
	}

	@Override
	public void addTraitment(@Valid TraitmentDTO traitmentDTO) {
		if (traitmentRepository.findByName(traitmentDTO.getName()).isEmpty()) {
			traitmentRepository.save(new Traitment(traitmentDTO));
		} else
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, traitmentDTO.getName() + " already exists");
	}

	@Override
	public void deleteTraitment(int id) {
		Optional<Traitment> traitment = traitmentRepository.findById(id);
		if (traitment.isPresent())
			traitmentRepository.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Traitment with id " + id + " not found");
	}

}

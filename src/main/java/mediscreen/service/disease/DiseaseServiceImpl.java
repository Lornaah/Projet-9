package mediscreen.service.disease;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mediscreen.dto.DiseaseDTO;
import mediscreen.model.Disease;
import mediscreen.repository.DiseaseRepository;

@Service
public class DiseaseServiceImpl implements DiseaseService {

	@Autowired
	DiseaseRepository diseaseRepository;

	@Override
	public List<DiseaseDTO> getAllDiseases() {
		List<Disease> diseaseList = diseaseRepository.findAll();
		List<DiseaseDTO> diseaseDTOList = new ArrayList<>();
		diseaseList.forEach(d -> {
			DiseaseDTO diseaseDTO = new DiseaseDTO(d);
			diseaseDTOList.add(diseaseDTO);
		});
		return diseaseDTOList;
	}

	@Override
	public DiseaseDTO getDisease(int id) {
		if (diseaseRepository.findById(id).isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Disease with id : " + id + " not found ");
		return new DiseaseDTO(diseaseRepository.findById(id).get());
	}

	@Override
	public void addDisease(String diseaseName) {
		if (diseaseRepository.findByName(diseaseName).isEmpty()) {
			DiseaseDTO disease = new DiseaseDTO(diseaseName);
			diseaseRepository.save(new Disease(disease));
		} else
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
					"The Disease : " + diseaseName + " already exists ");

	}

	@Override
	public void deleteDisease(int id) {
		Optional<Disease> disease = diseaseRepository.findById(id);
		if (disease.isPresent())
			diseaseRepository.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Disease with id : " + id + " not found ");
	}

}

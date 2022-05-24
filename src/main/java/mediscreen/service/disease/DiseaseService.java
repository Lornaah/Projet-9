package mediscreen.service.disease;

import java.util.List;

import mediscreen.dto.DiseaseDTO;

public interface DiseaseService {

	List<DiseaseDTO> getAllDiseases();

	DiseaseDTO getDisease(int id);

	DiseaseDTO addDisease(String disease);

	void deleteDisease(int id);

}
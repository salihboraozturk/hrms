package hrms.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.dto.CurriculumVitaeDto;

public interface CandidateService {
	Result add(Candidate candidate);

	DataResult<List<Candidate>> getAll();

	DataResult<Candidate> getByIdentificationNumber(String identificationNumber);

	DataResult<Candidate> getById(int candidateId);

	DataResult<CurriculumVitaeDto> getCVByCandidate(int candidateId);

	Result changeDescription(int candidateId, String description);

	Result uploadPhoto(int candidateId, MultipartFile file);
}

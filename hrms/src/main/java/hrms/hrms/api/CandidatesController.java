package hrms.hrms.api;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.business.abstracts.JobPositionService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.concretes.JobPosition;
import hrms.hrms.entities.dto.CurriculumVitaeDto;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {
		return  candidateService.getAll();
	}
	@PostMapping("/changeDescription")
	public Result addDescription(@RequestParam int candidateId,@RequestParam String description)
	{
		return this.candidateService.changeDescription(candidateId, description);
	}

	
	@GetMapping("/getCVByCandidate")
	public DataResult<CurriculumVitaeDto> getCVByCandidateId(@RequestParam int candidateId)
	{
		return this.candidateService.getCVByCandidate(candidateId);
	}
}

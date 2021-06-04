package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.business.abstracts.*;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CandidateDao;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.dto.CurriculumVitaeDto;

@Service
public class CandidateManager implements CandidateService {
	private CandidateDao candidateDao;
	private JobExperienceService jobExperienceService;
	private LanguageService languageService;
	private LinkService linkService;
	private SchoolService schoolService;
	private SkillService skillService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, LinkService linkService,
			JobExperienceService jobExperienceService, LanguageService languageService, SchoolService schoolService,
			SkillService skillService) {
		this.candidateDao = candidateDao;
		this.linkService = linkService;
		this.jobExperienceService = jobExperienceService;
		this.languageService = languageService;
		this.schoolService = schoolService;
		this.skillService = skillService;
	}

	@Override
	public Result add(Candidate candidate) {
		candidateDao.save(candidate);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll());
	}

	@Override
	public DataResult<Candidate> getByIdentificationNumber(String identificationNumber) {
		return new SuccessDataResult<Candidate>(candidateDao.getByIdentificationNumber(identificationNumber));
	}

	@Override
	public DataResult<Candidate> getById(int candidateId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(candidateId));
	}

	@Override
	public DataResult<CurriculumVitaeDto> getCVByCandidate(int candidateId) {
		CurriculumVitaeDto dto = new CurriculumVitaeDto();
		dto.setCandidate(this.getById(candidateId).getData());
		dto.setCandidateLinks(this.linkService.getByCandidateId(candidateId).getData());
		dto.setJobExperiences(this.jobExperienceService.getByCandidate(candidateId).getData());
		dto.setLanguages(this.languageService.getByCandidate(candidateId).getData());
		dto.setSchools(this.schoolService.getByCandidate(candidateId).getData());
		dto.setSkills(this.skillService.getByCandidate(candidateId).getData());

		return new SuccessDataResult<CurriculumVitaeDto>(dto);
	}

	@Override
	public Result changeDescription(int candidateId, String description) {
		Candidate candidateToAddDescription = this.getById(candidateId).getData();
		candidateToAddDescription.setDescription(description);
		this.candidateDao.save(candidateToAddDescription);
		return new SuccessResult();
	}

}

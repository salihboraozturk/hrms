package hrms.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.business.abstracts.*;
import hrms.hrms.core.utilities.image.ImageService;
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
	private ImageService imageService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, LinkService linkService,
			JobExperienceService jobExperienceService, LanguageService languageService, SchoolService schoolService,
			SkillService skillService, ImageService imageService) {
		this.candidateDao = candidateDao;
		this.linkService = linkService;
		this.jobExperienceService = jobExperienceService;
		this.languageService = languageService;
		this.schoolService = schoolService;
		this.skillService = skillService;
		this.imageService = imageService;
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

	@Override
	public Result uploadPhoto(int candidateId, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) this.imageService.uploadPhoto(file).getData();
		String url = result.get("url");
		Candidate candidateToAddPhoto = this.getById(candidateId).getData();
		candidateToAddPhoto.setImageUrl(url);
		this.candidateDao.save(candidateToAddPhoto);
		return new SuccessResult();
	}
	@Override
	public Result update(Candidate candidate)
	{
		this.candidateDao.save(candidate);
		return new SuccessResult("Kullanıcı Bilgileri Güncellendi");
	}
	@Override
	public Result updateCV(Candidate candidate)
	{
		Candidate candidateToUpdate = this.getById(candidate.getId()).getData();
		candidateToUpdate.setBirthYear(candidate.getBirthYear());
		candidateToUpdate.setDescription(candidate.getDescription());
		candidateToUpdate.setEmail(candidate.getEmail());
		candidateToUpdate.setFirstName(candidate.getFirstName());
		candidateToUpdate.setLastName(candidate.getLastName());
		this.candidateDao.save(candidateToUpdate);
		return new SuccessResult("Kullanıcı Bilgileri Güncellendi");
	}
}

package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobExperienceService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobExperienceDao;
import hrms.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {
	private JobExperienceDao jobExperienceDao;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getByCandidate(int candidateId) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobExperience>> getCandidateJobExperiencesDesc(int candidateId) {
		return new SuccessDataResult<List<JobExperience>>(
				this.jobExperienceDao.getByCandidate_IdOrderByFinishDateDesc(candidateId));
	}
	
	@Override
	public Result update(JobExperience jobExperience)
	{
		JobExperience jobExperienceToUpdate = this.jobExperienceDao.getById(jobExperience.getId());
		jobExperienceToUpdate.setFinishDate(jobExperience.getFinishDate());
		jobExperienceToUpdate.setPosition(jobExperience.getPosition());
		jobExperienceToUpdate.setStartDate(jobExperience.getStartDate());
		jobExperienceToUpdate.setWorkplaceName(jobExperience.getWorkplaceName());
		this.jobExperienceDao.save(jobExperienceToUpdate);
		return new SuccessResult("Kullanıcı bilgileri güncellendi");
	}
}
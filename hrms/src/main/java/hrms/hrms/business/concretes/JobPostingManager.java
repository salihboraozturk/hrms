package hrms.hrms.business.concretes;
 
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobPostingService;
import hrms.hrms.business.constants.Messages;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobPostingDao;
import hrms.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {
	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(), Messages.listedSuccess);
	}

	@Override
	public Result add(JobPosting jobPosting) {

		this.jobPostingDao.save(jobPosting);
		return new SuccessResult(Messages.savingSuccess);
	}

	@Override
	public DataResult<List<JobPosting>> getActivePostings() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrue(), Messages.listedSuccess);
	}

	@Override
	public DataResult<List<JobPosting>> getIsActiveTrueAndDeadlineDateEquals(Date deadlineDate) {
		return new SuccessDataResult<List<JobPosting>>(
				this.jobPostingDao.findByIsActiveTrueAndDeadlineDateEquals(deadlineDate), Messages.listedSuccess);
	}

	@Override
	public DataResult<List<JobPosting>> getIsActiveTrueAndEmployerId(int employerId) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrueAndEmployer(employerId),
				Messages.listedSuccess);
	}

	@Override
	public Result changeJobPostingIsActivity(int jobPostingId) {
		JobPosting jobPostingToUpdate = this.jobPostingDao.findById(jobPostingId);
		if (jobPostingToUpdate.isActive() == true) {
			jobPostingToUpdate.setActive(false);
		} else {
			jobPostingToUpdate.setActive(true);
		}

		this.jobPostingDao.save(jobPostingToUpdate);
		return new SuccessResult(Messages.changeStatus);
	}
}
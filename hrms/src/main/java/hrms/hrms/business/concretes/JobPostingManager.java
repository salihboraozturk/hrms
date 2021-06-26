package hrms.hrms.business.concretes;
 
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	
	@Override
	public DataResult<List<JobPosting>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(pageable).getContent());
	}
	
	@Override
	public DataResult<JobPosting> getById(int jobPostingId)
	{
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.findById(jobPostingId));
	}
	
	@Override
	public DataResult<List<JobPosting>> getByCityIdAndWorkingTimeId(int cityId, int workingTimeId)
	{
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrueAndCity_IdAndWorkingTime_Id(cityId, workingTimeId));
	}

	@Override
	public DataResult<List<JobPosting>> getByCityId(int cityId)
	{
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrueAndCity_Id(cityId));
	}

	@Override
	public DataResult<List<JobPosting>> getByWorkingTimeId(int workingTimeId)
	{
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrueAndWorkingTime_Id(workingTimeId));
	}
	
}
package hrms.hrms.business.abstracts;

import java.sql.Date;
import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	DataResult<List<JobPosting>> getAll();

	Result add(JobPosting jobPosting);

	DataResult<List<JobPosting>> getActivePostings();

	DataResult<List<JobPosting>> getIsActiveTrueAndDeadlineDateEquals(Date deadlineDate);

	DataResult<List<JobPosting>> getIsActiveTrueAndEmployerId(int employerId);

	Result changeJobPostingIsActivity(int jobPostingId);

	 DataResult<List<JobPosting>> getAll(int pageNo, int pageSize);
	 
	DataResult<JobPosting> getById(int jobPostingId);

	DataResult<List<JobPosting>> getByCityIdAndWorkingTimeId(int cityId, int workingTimeId);

	DataResult<List<JobPosting>> getByCityId(int cityId);

	DataResult<List<JobPosting>> getByWorkingTimeId(int workingTimeId);
}
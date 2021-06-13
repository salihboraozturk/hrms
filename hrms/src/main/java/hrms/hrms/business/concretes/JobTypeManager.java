package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobTypeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobTypeDao;
import hrms.hrms.entities.concretes.JobType;

@Service
public class JobTypeManager implements JobTypeService {

	JobTypeDao jobTypeDao;

	@Autowired
	public JobTypeManager(JobTypeDao jobTypeDao) {
		super();
		this.jobTypeDao = jobTypeDao;
	}

	@Override
	public DataResult<List<JobType>> getAllJobTypes() {
		return new SuccessDataResult<List<JobType>>(jobTypeDao.findAll());
	}

	@Override
	public Result Add(JobType jobType) {
	   jobTypeDao.save(jobType);
		return new SuccessResult();
	}
}

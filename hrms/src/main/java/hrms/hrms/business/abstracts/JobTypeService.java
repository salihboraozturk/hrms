package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobType;

public interface JobTypeService {
	DataResult<List<JobType>> getAllJobTypes();

	Result Add(JobType jobType);
}

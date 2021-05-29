package hrms.hrms.business.abstracts;
 
import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult <List<JobPosition>> getAll();
	Result add(JobPosition jobPosition);
	DataResult <JobPosition> getJobPositionByName(String positionName);
}

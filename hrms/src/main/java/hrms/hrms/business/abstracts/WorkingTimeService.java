package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.WorkingTime;

public interface WorkingTimeService {

	DataResult<List<WorkingTime>> getAllWorkingTimes();

	Result add(WorkingTime workingTime);
}

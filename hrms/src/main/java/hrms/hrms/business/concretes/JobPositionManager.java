package hrms.hrms.business.concretes;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobPositionService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobPositionDao;
import hrms.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if (getJobPositionByName(jobPosition.getPositionName()).getData() == null) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult();
		} else {
			return new ErrorResult();

		}

	}

	@Override
	public DataResult<JobPosition> getJobPositionByName(String positionName) {

		return new SuccessDataResult<JobPosition>(jobPositionDao.getByPositionName(positionName));
	}

}

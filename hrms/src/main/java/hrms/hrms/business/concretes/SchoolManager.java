package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.SchoolService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.SchoolDao;
import hrms.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {
	private SchoolDao schoolDao;

	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getByCandidate(int candidateId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<School>> getCandidateSchoolsDesc(int candidateId) {
		return new SuccessDataResult<List<School>>(
				this.schoolDao.getByCandidate_IdOrderByGraduateDateDesc(candidateId));
	}
}

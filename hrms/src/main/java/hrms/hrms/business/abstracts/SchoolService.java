package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.School;

public interface SchoolService
{
	DataResult<List<School>> getByCandidate(int candidateId);
	Result add(School school);
	DataResult<List<School>> getCandidateSchoolsDesc(int candidateId);
	Result update(School school);
}

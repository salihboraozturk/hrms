package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Skill;

public interface SkillService
{
	DataResult<List<Skill>> getByCandidate(int candidateId);
	Result add(Skill skill);
}

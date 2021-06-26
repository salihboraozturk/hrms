package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobExperience;

public interface JobExperienceService
{
	DataResult<List<JobExperience>> getByCandidate(int candidateId);
	Result add(JobExperience jobExperience);
	DataResult<List<JobExperience>> getCandidateJobExperiencesDesc(int candidateId);
	Result update(JobExperience jobExperience);
}

package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;

public interface CandidateService {
Result add(Candidate candidate);
DataResult<List<Candidate>> getAll();
DataResult<Candidate> getByIdentificationNumber(String identificationNumber);
}

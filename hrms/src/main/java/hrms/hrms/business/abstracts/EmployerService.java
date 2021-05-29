package hrms.hrms.business.abstracts;
 
import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.concretes.Employer;

public interface EmployerService {
Result add(Employer employer);
DataResult<List<Employer>> getAll();
}

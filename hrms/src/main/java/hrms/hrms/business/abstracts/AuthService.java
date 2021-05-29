package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.dto.CandidateForRegisterDto;
import hrms.hrms.entities.dto.EmployerForRegisterDto;
import hrms.hrms.entities.dto.UserForLoginDto;
 
public interface AuthService {
	Result registerForCandidate(CandidateForRegisterDto candidateForRegisterDto);
	Result registerForEmployer(EmployerForRegisterDto employerForRegisterDto);
}

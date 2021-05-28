package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.AuthService;
import hrms.hrms.business.abstracts.JobPositionService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.concretes.JobPosition;
import hrms.hrms.entities.dto.CandidateForRegisterDto;
import hrms.hrms.entities.dto.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	AuthService  authService;

	@Autowired
	public AuthController(AuthService  authService) {
		this.authService = authService;
	}

	@PostMapping("/registerForCandidate")
	public Result registerForCandidate(@RequestBody CandidateForRegisterDto candidateForRegisterDto) {
		return authService.registerForCandidate(candidateForRegisterDto) ;
	}
	
	@PostMapping("/registerForEmployer")
	public Result registerForEmployer(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
		return authService.registerForEmployer(employerForRegisterDto) ;
	}
}

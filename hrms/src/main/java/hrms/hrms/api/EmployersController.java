package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.concretes.Employer;

@CrossOrigin
@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return employerService.getAll();
	}
	@GetMapping("/getbyid")
	public DataResult<Employer> getById(@RequestParam int employerId) {
		return employerService.getById(employerId);
	}

	@PostMapping("/uploadcompanylogo")
	public Result uploadCompanyPhoto(@RequestParam int employerId, @RequestBody MultipartFile file) {
		return this.employerService.uploadCompanyPhoto(employerId, file);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Employer employer)
	{
		return this.employerService.update(employer);
	}
	
	@PostMapping("/confirmUpdate")
	public Result confirmUpdate(@RequestParam int employerId)
	{
		return this.employerService.confirmUpdate(employerId);
	}
}

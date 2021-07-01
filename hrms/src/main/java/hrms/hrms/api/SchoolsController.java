package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.SchoolService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.School;

@CrossOrigin
@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		this.schoolService = schoolService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}

	@GetMapping("/getCandidateSchoolsDesc")
	public DataResult<List<School>> getCandidateSchoolsDesc(@RequestParam int candidateId) {
		return this.schoolService.getCandidateSchoolsDesc(candidateId);
	}

	@PostMapping("/update")
	public Result update(@RequestBody School school) {
		return this.schoolService.update(school);
	}

	@DeleteMapping("/deletebyid")
	public Result deleteById(@RequestParam int schoolId) {
		return this.schoolService.deleteById(schoolId);
	}
}
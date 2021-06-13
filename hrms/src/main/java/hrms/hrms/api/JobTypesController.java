package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobTypeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobType;

@RestController
@RequestMapping("/api/jobtypes")
public class JobTypesController {

	JobTypeService jobTypeService;

	@Autowired
	public JobTypesController(JobTypeService jobTypeService) {
		super();
		this.jobTypeService = jobTypeService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobType>> getAllJobTypes() {
		return jobTypeService.getAllJobTypes();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobType jobType) {
		return jobTypeService.Add(jobType);
	}

}

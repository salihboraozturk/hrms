package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.WorkingTimeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.WorkingTime;
@CrossOrigin
@RequestMapping("/api/workingtimes")
@RestController
public class WorkingTimesController {
	WorkingTimeService workingTimeService;

	@Autowired
	public WorkingTimesController(WorkingTimeService workingTimeService) {
		super();
		this.workingTimeService = workingTimeService;
	}

	@GetMapping("/getall")
	public DataResult<List<WorkingTime>> getAll() {
		return workingTimeService.getAllWorkingTimes();
	}

	@PostMapping("/add")
	public Result add(@RequestBody WorkingTime workingTime) {
		return workingTimeService.add(workingTime);
	}

}

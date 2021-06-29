package hrms.hrms.api;

import java.util.List;

import javax.persistence.PostUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.SystemUserService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.SystemUser;

@CrossOrigin
@RestController
@RequestMapping("/api/systemuser")
public class SystemUsersController {
	private SystemUserService systemUserService;

	@Autowired
	public SystemUsersController(SystemUserService systemUserService) {
		this.systemUserService = systemUserService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody SystemUser systemUser) {
		return this.systemUserService.add(systemUser);
	}

	@PutMapping("/update")
	public Result update(@RequestBody SystemUser systemUser) {
		return this.systemUserService.update(systemUser);
	}

	@DeleteMapping("/deletebyid")
	public Result update(@RequestParam int id) {
		return this.systemUserService.deleteById(id);
	}

	@GetMapping("/getbyid")
	public DataResult<SystemUser> getById(@RequestParam int id) {
		return this.systemUserService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<SystemUser>> getall() {
		return this.systemUserService.getAll();
	}
}

package hrms.hrms.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.SkillService;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Skill;

@CrossOrigin
@RestController
@RequestMapping("/api/skills")
public class SkillsController {
	private SkillService skillService;

	public SkillsController(SkillService skillService) {
		this.skillService = skillService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Skill skill) {
		return this.skillService.add(skill);
	}

	@PostMapping("/update")
	public Result update(@RequestBody Skill skill) {
		return this.skillService.update(skill);
	}

	@DeleteMapping("/deletebyid")
	public Result deleteById(@RequestParam int skillId) {
		return this.skillService.deleteById(skillId);
	}
}

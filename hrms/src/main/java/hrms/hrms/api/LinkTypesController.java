package hrms.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.LinkTypeService;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.LinkType;

@CrossOrigin
@RestController
@RequestMapping("/api/linktypes")
public class LinkTypesController {
	private LinkTypeService linkTypeService;

	@Autowired
	public LinkTypesController(LinkTypeService linkTypeService) {
		this.linkTypeService = linkTypeService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody LinkType linkType) {
		return this.linkTypeService.add(linkType);
	}

	@GetMapping("/getall")
	public Result getAll() {
		return this.linkTypeService.getAll();
	}

}

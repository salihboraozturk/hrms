package hrms.hrms.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.LinkService;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Link;
@CrossOrigin
@RestController
@RequestMapping("/api/links")
public class LinksController {
	private LinkService linkService;

	public LinksController(LinkService linkService) {
		this.linkService = linkService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Link link) {
		return this.linkService.add(link);
	}
	@PostMapping("/update")
	public Result update(@RequestBody Link link)
	{
		return this.linkService.update(link);
	}
}

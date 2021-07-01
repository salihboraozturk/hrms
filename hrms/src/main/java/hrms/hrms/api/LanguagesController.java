package hrms.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.LanguageService;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Language;

@CrossOrigin
@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Language language) {
		return this.languageService.add(language);
	}

	@PostMapping("/update")
	public Result update(@RequestBody Language language) {
		return this.languageService.update(language);
	}

	@DeleteMapping("/deletebyid")
	public Result deleteById(@RequestParam int languageId) {
		return this.languageService.deleteById(languageId);
	}
}
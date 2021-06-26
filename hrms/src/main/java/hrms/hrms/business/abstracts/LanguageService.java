package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Language;

public interface LanguageService
{
	DataResult<List<Language>> getByCandidate(int candidateId);
	Result add(Language language);
	Result update(Language language);
}

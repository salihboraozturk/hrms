package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.LanguageService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.LanguageDao;
import hrms.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService
{
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao)
	{
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getByCandidate(int candidateId)
	{
		return new SuccessDataResult<List<Language>>(this.languageDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result add(Language language)
	{
		this.languageDao.save(language);
		return new SuccessResult();
	}
}

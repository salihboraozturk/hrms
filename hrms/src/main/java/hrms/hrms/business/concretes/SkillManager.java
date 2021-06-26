package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.SkillService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.SkillDao;
import hrms.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService
{
	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao)
	{
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<Skill>> getByCandidate(int candidateId)
	{
		return new SuccessDataResult<List<Skill>>(this.skillDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result add(Skill skill)
	{
		this.skillDao.save(skill);
		return new SuccessResult();
	}
	
	@Override
	public Result update(Skill skill)
	{
		Skill skillToUpdate = this.skillDao.getById(skill.getId());
		skillToUpdate.setSkillName(skill.getSkillName());
		this.skillDao.save(skillToUpdate);
		return new SuccessResult("Kullanıcı Bilgileri Güncellendi");
	}
}
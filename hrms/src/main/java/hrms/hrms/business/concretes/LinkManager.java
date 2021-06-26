package hrms.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.LinkService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.LinkDao;
import hrms.hrms.entities.concretes.Link;

@Service
public class LinkManager implements LinkService {

	private LinkDao linkDao;

	@Autowired
	public LinkManager(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	@Override
	public DataResult<List<Link>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Link>>(this.linkDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result add(Link link) {
		this.linkDao.save(link);
		return new SuccessResult();
	}
	
	@Override
	public Result update(Link link)
	{ 
		Link  linkToUpdate = linkDao.findById(link.getId());
		linkToUpdate.setLinkPath(link.getLinkPath());
		this.linkDao.save(linkToUpdate);
		return new SuccessResult("Kullanıcı Bilgileri Güncellendi");
	}
}

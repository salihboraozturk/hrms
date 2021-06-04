package hrms.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.LinkTypeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.LinkTypeDao;
import hrms.hrms.entities.concretes.LinkType;

@Service
public class LinkTypeManager implements LinkTypeService {
	private LinkTypeDao linkTypeDao;

	@Autowired
	public LinkTypeManager(LinkTypeDao linkTypeDao) {
		this.linkTypeDao = linkTypeDao;
	}

	@Override
	public Result add(LinkType linkType) {
		this.linkTypeDao.save(linkType);
		return new SuccessResult();
	}

	@Override
	public DataResult<LinkType> getById(int linkTypeId) {
		return new SuccessDataResult<LinkType>(this.linkTypeDao.getById(linkTypeId));
	}
}
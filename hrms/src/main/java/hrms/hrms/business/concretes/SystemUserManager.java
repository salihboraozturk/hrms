package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.SystemUserService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.SystemUserDao;
import hrms.hrms.entities.concretes.SystemUser;

@Service
public class SystemUserManager implements SystemUserService {
	private SystemUserDao systemUserDao;

	@Autowired
	public SystemUserManager(SystemUserDao systemUserDao) {
		this.systemUserDao = systemUserDao;
	}

	@Override
	public Result add(SystemUser systemUser) {

		this.systemUserDao.save(systemUser);
		return new SuccessResult();
	}

	@Override
	public Result deleteById(int id) {
		this.systemUserDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public Result update(SystemUser systemUser) {
		this.systemUserDao.save(systemUser);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<SystemUser>> getAll() {

		return new SuccessDataResult<List<SystemUser>>(this.systemUserDao.findAll());
	}

	@Override
	public DataResult<SystemUser> getById(int id) {

		return new SuccessDataResult<SystemUser>(this.systemUserDao.getById(id));
	}

}

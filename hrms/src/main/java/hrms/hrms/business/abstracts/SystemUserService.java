package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.SystemUser;

public interface SystemUserService {
	Result add(SystemUser systemUser);
	Result deleteById(int id);
	Result update(SystemUser systemUser);
	DataResult<List<SystemUser>> getAll();
	DataResult<SystemUser> getById(int id);
}

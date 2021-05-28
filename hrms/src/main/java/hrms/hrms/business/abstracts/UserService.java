package hrms.hrms.business.abstracts;

import org.springframework.stereotype.Service;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.User;

public interface UserService {
	DataResult<User> getByEmail(String email);

}

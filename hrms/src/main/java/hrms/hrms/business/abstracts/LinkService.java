package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Link;

public interface LinkService {

	DataResult<List<Link>> getByCandidateId(int candidateId);
	Result add(Link link);
	Result update(Link link);
}

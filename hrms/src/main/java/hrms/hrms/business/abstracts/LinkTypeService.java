package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.LinkType;

public interface LinkTypeService
{
	Result add(LinkType linkType);
	DataResult<LinkType> getById(int linkTypeId);
}

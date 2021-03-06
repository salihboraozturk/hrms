package hrms.hrms.business.concretes;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.image.ImageService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EmployerDao;
import hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;
	private ImageService imageService;
	private ObjectMapper objectMapper;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,ImageService imageService,ObjectMapper objectMapper) {
		this.employerDao = employerDao;
		this.imageService = imageService;
		this.objectMapper=objectMapper;
	}

	@Override
	public Result add(Employer employer) {
		employerDao.save(employer);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll());
	}

	@Override
	public Result uploadCompanyPhoto(int employerId, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) this.imageService.uploadPhoto(file).getData();
		String url = result.get("url");
		Employer employerToAddPhoto = this.getById(employerId).getData();
		employerToAddPhoto.setCompanyLogo(url);
		this.employerDao.save(employerToAddPhoto);
		return new SuccessResult();
	}
 
	@Override
	public DataResult<Employer> getById(int employerId) {

		return new SuccessDataResult<Employer>(this.employerDao.getById(employerId));
	}
	
	@Override
	public Result update(Employer employer)
	{
		Employer employerToUpdate = this.getById(employer.getId()).getData();
		Map<String,Object> update = this.objectMapper.convertValue(employer,Map.class);
		employerToUpdate.setUpdate(update);
		this.employerDao.save(employerToUpdate);
		return new SuccessResult("G??ncelleme ??stedi??iniz Al??nd??.");
	}
 
	@Override
	public Result confirmUpdate(int employerId)
	{
		Employer employerToConfirmUpdate = this.getById(employerId).getData();
		Employer tempEmployer = this.objectMapper.convertValue(employerToConfirmUpdate.getUpdate(), Employer.class);
		tempEmployer.setUpdate(null);
		this.employerDao.save(tempEmployer);
		return new SuccessResult("G??ncelleme Onayland??");
	}

}

package hrms.hrms.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.AuthService;
import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.business.constants.Messages;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.core.utilities.validation.mail.MailValidationService;
import hrms.hrms.core.utilities.validation.person.PersonValidationService;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.dto.CandidateForRegisterDto;
import hrms.hrms.entities.dto.EmployerForRegisterDto;

@Service
public class AuthManager implements AuthService {
	private ModelMapper modelMapper;
	private CandidateService candidateService;
	private EmployerService employerService;
	private UserService userService;
	private PersonValidationService personValidationService;
	private MailValidationService mailValidationService;

	@Autowired
	public AuthManager(ModelMapper modelMapper, CandidateService candidateService, EmployerService employerService,
			UserService userService, PersonValidationService personValidationService,
			MailValidationService mailValidationService) {
		this.modelMapper = modelMapper;
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.userService = userService;
		this.personValidationService = personValidationService;
		this.mailValidationService = mailValidationService;

	}

	@Override
	public Result registerForCandidate(CandidateForRegisterDto candidateForRegisterDto) {
		if (candidateForRegisterDto.getFirstName() == null && candidateForRegisterDto.getLastName() == null
				&& candidateForRegisterDto.getIdentificationNumber() == null
				&& candidateForRegisterDto.getBirthYear() == null && candidateForRegisterDto.getEMail() == null
				&& candidateForRegisterDto.getPassword() == null) {
			return new ErrorResult(Messages.checkForm);
		}
		if (!personValidationService.validate(candidateForRegisterDto.getIdentificationNumber(),
				candidateForRegisterDto.getFirstName(), candidateForRegisterDto.getLastName(),
				candidateForRegisterDto.getBirthYear())) {
			return new ErrorResult(Messages.wrongInfos);
		}

		if (this.userService.getByEmail(candidateForRegisterDto.getEMail()).getData() != null && this.candidateService
				.getByIdentificationNumber(candidateForRegisterDto.getIdentificationNumber()).getData() != null) {
			return new ErrorResult(Messages.emailAndIdentityExists);
		}

		Candidate candidatesForRegister = modelMapper.map(candidateForRegisterDto, Candidate.class);
		candidateService.add(candidatesForRegister);
		return new SuccessResult(Messages.savingSuccess);

	}

	@Override
	public Result registerForEmployer(EmployerForRegisterDto employerForRegisterDto) {
		if (employerForRegisterDto.getCompanyName() == null && employerForRegisterDto.getWebAddress() == null
				&& employerForRegisterDto.getPhoneNumber() == null && employerForRegisterDto.getEMail() == null
				&& employerForRegisterDto.getPassword() == null && checkDomain(employerForRegisterDto)) {
			return new ErrorResult(Messages.checkForm);
		}
		if (this.userService.getByEmail(employerForRegisterDto.getEMail()).getData() != null) {
			return new ErrorResult(Messages.emailExists);
		}
		mailValidationService.mailSend(employerForRegisterDto.getEMail());
		Employer employerForRegister = modelMapper.map(employerForRegisterDto, Employer.class);
		employerService.add(employerForRegister);
		return new SuccessResult(Messages.savingSuccess);
	}

	private boolean checkDomain(EmployerForRegisterDto employerForRegisterDto) {
		String checkDomain = employerForRegisterDto.getEMail().split("@")[1];
		return checkDomain.equals(employerForRegisterDto.getWebAddress());
	}
}

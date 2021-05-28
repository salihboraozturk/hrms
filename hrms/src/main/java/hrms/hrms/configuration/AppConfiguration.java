package hrms.hrms.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hrms.hrms.core.utilities.validation.mail.MailValidationManager;
import hrms.hrms.core.utilities.validation.mail.MailValidationService;
import hrms.hrms.core.utilities.validation.person.PersonValidationAdapter;
import hrms.hrms.core.utilities.validation.person.PersonValidationService;

@Configuration
public class AppConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

	@Bean
	public PersonValidationService personValidationService() {
		return new PersonValidationAdapter();
	}

	@Bean
	public MailValidationService mailValidationService() {
		return new MailValidationManager();
	}
}

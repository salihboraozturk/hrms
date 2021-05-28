package hrms.hrms.core.utilities.validation.person;

import org.springframework.stereotype.Service;

@Service
public class PersonValidationAdapter implements PersonValidationService {

	@Override
	public boolean validate(String identityNumber, String firstName, String lastName, String birthYear) {
		return true;
	}

}

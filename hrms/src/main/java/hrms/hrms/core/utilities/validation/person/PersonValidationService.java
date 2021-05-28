package hrms.hrms.core.utilities.validation.person;

public interface PersonValidationService {
	boolean validate(String identityNumber, String firstName, String lastName, String birthYear);
}

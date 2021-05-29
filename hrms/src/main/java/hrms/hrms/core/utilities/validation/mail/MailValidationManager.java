package hrms.hrms.core.utilities.validation.mail;
 
public class MailValidationManager implements MailValidationService {

	@Override
	public boolean mailSend(String eMail) {
	System.out.println(eMail+" mail adresine kod gönderildi.");
	return true;
	}

}

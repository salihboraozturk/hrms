package hrms.hrms.entities.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegisterDto {
	private String eMail;
	private String password;
	private String passwordRepeat;
	private String companyName;
	private String webAddress;
	private String phoneNumber;

}

package hrms.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateForRegisterDto {
private String firstName;
private String lastName;
private String identificationNumber;
private String birthYear;
private String eMail;
private String password;
private String passwordRepeat;
}

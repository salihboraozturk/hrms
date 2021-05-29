package hrms.hrms.dataAccess.abstracts;
 
import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	Candidate getByIdentificationNumber(String identificationNumber);

}

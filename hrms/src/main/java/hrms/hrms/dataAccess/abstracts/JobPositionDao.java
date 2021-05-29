package hrms.hrms.dataAccess.abstracts;
 
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	JobPosition getByPositionName(String positionName);
}

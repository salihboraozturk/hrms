package hrms.hrms.dataAccess.abstracts;
 
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	
	List<JobPosting> findByIsActiveTrue();

	List<JobPosting> findByIsActiveTrueAndDeadlineDateEquals(Date deadlineDate);

	List<JobPosting> findByIsActiveTrueAndEmployer(int employerId);

	JobPosting findById(int jobPostingId);
	
	List<JobPosting> findByIsActiveTrueAndCity_IdAndWorkingTime_Id(int cityId,int workingTimeId);
	
	List<JobPosting> findByIsActiveTrueAndCity_Id(int cityId);
	
	List<JobPosting> findByIsActiveTrueAndWorkingTime_Id(int workingTimeId);
}

package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>
{
	List<JobExperience> getByCandidate_Id(int candidateId);
	List<JobExperience> getByCandidate_IdOrderByFinishDateDesc(int candidateId);
	JobExperience getById(int jobExperienceId);
}

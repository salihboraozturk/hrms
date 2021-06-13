package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobType;

public interface JobTypeDao  extends JpaRepository<JobType, Integer>{
}

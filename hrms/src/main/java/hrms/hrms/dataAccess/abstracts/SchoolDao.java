package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>
{
	List<School> getByCandidate_Id(int candidateId);
	List<School> getByCandidate_IdOrderByGraduateDateDesc(int candidateId);
	School getById(int schoolId);
}
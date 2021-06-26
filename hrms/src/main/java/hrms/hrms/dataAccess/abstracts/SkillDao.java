package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer>
{
	List<Skill> getByCandidate_Id(int candidateId);
	Skill getById(int skillId);
}
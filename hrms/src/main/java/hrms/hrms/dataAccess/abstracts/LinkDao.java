package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.Link;

public interface LinkDao extends JpaRepository<Link, Integer> {
	List<Link> getByCandidate_Id(int candidateId);
}

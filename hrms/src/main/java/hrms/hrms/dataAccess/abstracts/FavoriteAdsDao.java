package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.FavoriteAds;

public interface FavoriteAdsDao extends JpaRepository<FavoriteAds, Integer> {
	List<FavoriteAds> getByCandidate_Id(int candidateId);
	FavoriteAds getByCandidate_IdAndJobPostingId(int candidateId,int jobPostingId);
}

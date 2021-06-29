package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.business.abstracts.FavoriteAdsService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.FavoriteAdsDao;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.concretes.FavoriteAds;

@Service
public class FavoriteAdsManager implements FavoriteAdsService {
	private FavoriteAdsDao favoriteAdsDao;
	private CandidateService candidateService;

	@Autowired
	public FavoriteAdsManager(FavoriteAdsDao favoriteAdsDao, CandidateService candidateService) {
		this.favoriteAdsDao = favoriteAdsDao;
		this.candidateService = candidateService;
	}

	@Override
	public DataResult<List<FavoriteAds>> getFavoritesByCandidateId(int candidateId) {

		return new SuccessDataResult<List<FavoriteAds>>(this.favoriteAdsDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result changeJobPostingFavoriteStatus(int candidateId, int jobPostingId) {
		FavoriteAds favoriteAds = this.favoriteAdsDao.getByCandidate_IdAndJobPostingId(candidateId, jobPostingId);
		if (favoriteAds != null) {
			this.favoriteAdsDao.deleteById(favoriteAds.getId());
		} else {
			FavoriteAds favorite = new FavoriteAds();
			Candidate candidate = new Candidate();
			candidate = this.candidateService.getById(candidateId).getData();
			favorite.setCandidate(candidate);
			favorite.setJobPostingId(jobPostingId);
			this.favoriteAdsDao.save(favorite);
		}
		return new SuccessResult("Favori Güncellendi");
	}
}

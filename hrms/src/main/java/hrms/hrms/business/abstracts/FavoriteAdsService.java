package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.FavoriteAds;

public interface FavoriteAdsService {
	DataResult<List<FavoriteAds>> getFavoritesByCandidateId(int candidateId);
	Result changeJobPostingFavoriteStatus(int candidateId,int jobPostingId);
}

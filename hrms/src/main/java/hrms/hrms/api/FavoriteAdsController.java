package hrms.hrms.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.FavoriteAdsService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.FavoriteAds;

@CrossOrigin
@RestController
@RequestMapping("/api/favoriteads")
public class FavoriteAdsController {
	private FavoriteAdsService favoriteAdsService;

	@Autowired
	public FavoriteAdsController(FavoriteAdsService favoriteAdsService)
	{
		this.favoriteAdsService = favoriteAdsService;
	}

	@GetMapping("/getFavoritesByCandidateId")
	public DataResult<List<FavoriteAds>> getFavoritesByCandidateId(@RequestParam int candidateId)
	{
		return this.favoriteAdsService.getFavoritesByCandidateId(candidateId);
	}
	

	@PostMapping("/changejobpostingfavoritestatus")
	public Result changeJobPostingFavoriteStatus(@RequestParam int candidateId,@RequestParam int jobPostingId)
	{
		return this.favoriteAdsService.changeJobPostingFavoriteStatus(candidateId, jobPostingId);
	}
}

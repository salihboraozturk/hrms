package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favorite_ads")
@Entity
public class FavoriteAds
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "favorite_id")
	private int id;

	//@Column(name = "candidate_id")
	//private int candidateId;

	@Column(name = "job_posting_id")
	private int jobPostingId;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
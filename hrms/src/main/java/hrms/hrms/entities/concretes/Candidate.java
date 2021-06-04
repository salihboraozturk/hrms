package hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Candidate extends User {
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "identification_number")
	private String identificationNumber;
	@Column(name = "birth_year")
	private String birthYear;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "description")
	private String description;

	@Column(name = "is_activated")
	private boolean isActivated;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Link> links;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<JobExperience> jobExperiences;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Language> languages;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<School> schools;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Skill> skills;
}

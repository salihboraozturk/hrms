package hrms.hrms.entities.dto;

import java.util.List;

import hrms.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumVitaeDto {

	private Candidate candidate;
	private List<Link> candidateLinks;
	private List<JobExperience> jobExperiences;
	private List<School> schools;
	private List<Skill> skills;
	private List<Language> languages;

}

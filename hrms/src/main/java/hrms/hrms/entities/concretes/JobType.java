package hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_types")
public class JobType {
	@Id
	@Column(name = "job_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	@Column(name = "job_type_name")
	private String jobTypeName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobType")
	private List<JobPosting> jobPostings;

}

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
@Table(name = "working_times")
@NoArgsConstructor
@AllArgsConstructor
public class WorkingTime {
	@Id
	@Column(name = "working_time_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "working_time_name")
	private String workingTimeName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "workingTime")
	private List<JobPosting> jobPostings;
}

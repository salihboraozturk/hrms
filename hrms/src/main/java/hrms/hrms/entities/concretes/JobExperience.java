package hrms.hrms.entities.concretes;


import java.util.Date;


import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")
public class JobExperience {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	private int user_id;
	@Column(name = "workplace_name")
	private String workplaceName;
	@Column(name = "position")
	private String position;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "finish_date")
	private Date finishDate;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private Candidate candidate;

}

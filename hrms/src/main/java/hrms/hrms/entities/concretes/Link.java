package hrms.hrms.entities.concretes;

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
@Table(name = "candidate_links")
public class Link {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// @Column(name = "user_id")
	// private int userId;

	// @Column(name = "link_type_id")
	// private int linkTypeId;

	@Column(name = "link_path")
	private String linkPath;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private Candidate candidate;

	@ManyToOne()
	@JoinColumn(name = "link_type_id")
	private LinkType linkType;
}
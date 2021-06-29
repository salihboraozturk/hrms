package hrms.hrms.entities.concretes;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobPostings" })
@TypeDef(name = "json", typeClass = JsonType.class)
public class Employer extends User {
 
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "web_adress")
	private String webAddress;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "company_logo")
	private String companyLogo;
	@Column(name = "is_activated")
	private boolean isActivated;

	@Type(type = "json")
	@Column(name = "update_employer", columnDefinition = "jsonb")
	private Map<String, Object> update;

	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobPosting> jobPostings;
}

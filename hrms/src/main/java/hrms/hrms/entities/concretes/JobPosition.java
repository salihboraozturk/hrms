package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_positions")
public class JobPosition {
	@Id
	@GeneratedValue
	@Column(name = "position_id")
	private int position_id;
	@Column(name = "position_name")
	private String position_name;

	public JobPosition() {}
	
	public JobPosition(int position_id, String position_name) {
		super();
		this.position_id = position_id;
		this.position_name = position_name;
	}

	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
}

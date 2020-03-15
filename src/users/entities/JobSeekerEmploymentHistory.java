package users.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class JobSeekerEmploymentHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "companyName")
	private String companyName;

	@Column(name = "skill")
	private String skills;
	@Column(name = "companyName")
	private String project_name;

	@Column(name = "project-description")

	private String project_description;
	@Column(name = "project-duration")

	private double project_duration;

	public double getProject_duration() {
		return project_duration;
	}

	public void setProject_duration(double project_duration) {
		this.project_duration = project_duration;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_description() {
		return project_description;
	}

	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}

}

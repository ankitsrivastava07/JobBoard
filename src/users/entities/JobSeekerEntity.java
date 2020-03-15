package users.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class JobSeekerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany
	@JoinTable(name = "jobskeer_skills", joinColumns = {
			@JoinColumn(name = "jobskeer_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "skill_id", referencedColumnName = "id") })
	private List<SkillEntity> skills;
	
	private float totalExperience;

}

package users.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="countries")
public class CountryEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="phonecode")
	private int phonecode;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	  public String getName() { 
		  return name; 
	  }
	  
	  public void setName(String name) {
	  this.name = name; 
	  }
	 
	public int getPhoneCode() {
		return phonecode;
	}
	public void setPhoneCode(int code) {
		this.phonecode = code;
	}
}

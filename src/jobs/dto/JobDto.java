package jobs.dto;

public class JobDto {
	private String name;
	private String type;
	private String companyName;
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompany_name() {
		return companyName;
	}
	public void setCompany_name(String companyName) {
		this.companyName = companyName;
	}	
}

package version2;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Staff extends Employee implements Serializable {
	private String jobTitle;
	
	public Staff() {
    }
  
	public Staff(String name, String address, String phoneNumber, String email, String office, String salary, int year,
			int month, int day, String jobTitle) {
		super(name, address, phoneNumber, email, office, salary, year, month, day);
		this.jobTitle = jobTitle;
		}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
    public String toString() {
		return "Staff " + " 姓名: " + super.getName();
    }
}

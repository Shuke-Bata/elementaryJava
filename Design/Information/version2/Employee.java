package version2;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee extends Person implements Serializable {
	private String office;
    private String salary;
    private String time;
    private MyDate dataOfAppointment;
    
    public Employee() {
    }
    
    public Employee(String name, String address, String phoneNumber, String email, String office, 
    		String salary, int year, int month, int day) {
		super(name, address, phoneNumber, email);
		this.office = office;
		this.salary = salary;
		dataOfAppointment = new MyDate(year, month, day);
		time = year + "." + month + "." + day;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public MyDate getDataOfAppointment() {
		return dataOfAppointment;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Employee" + " 姓名: " + super.getName();
	}
}

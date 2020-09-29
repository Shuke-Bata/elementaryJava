package version1;

public class Employee extends Person {
	private String office;
    private double salary;
    private MyDate dataOfAppointment;
    
    public Employee() {
    }
    
    public Employee(String name, String address, String phoneNumber, String email, String office, 
    		double salary, int year, int month, int day) {
		super(name, address, phoneNumber, email);
		this.office = office;
		this.salary = salary;
		dataOfAppointment = new MyDate(year, month, day);
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public MyDate getDataOfAppointment() {
		return dataOfAppointment;
	}
	@Override
	public String toString() {
		return "Employee" + " 姓名: " + super.getName();
	}
}

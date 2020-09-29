package version2;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student extends Person implements Serializable {
	private String grade;
	
	final String GREAD_1 = "GreadOne"; 
	final String GREAD_2 = "GreadTwo"; 
	final String GREAD_3 = "GreadThree"; 
	final String GREAD_4 = "GreadFour"; 
	
    public Student() {
    	
    }
    
    public Student(String name,String address, String phoneNumber, String email,String grade){
        super(name,address,phoneNumber,email);
        switch ((int)Integer.valueOf(grade)) {
		case 1: this.grade = GREAD_1; break;
		case 2: this.grade = GREAD_2; break;
		case 3: this.grade = GREAD_3; break;
		case 4: this.grade = GREAD_4; break;
		default: this.grade = "Graduate";
		}
    }

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}
	
	@Override
	public String toString() {
		return "Student " + " 姓名: " + super.getName();
	}
    
}

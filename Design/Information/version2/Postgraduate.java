package version2;

@SuppressWarnings("serial")
public class Postgraduate extends Student implements java.io.Serializable {
	private String study;
	private String tutor;	
	
	public Postgraduate() {
	}
	
	public Postgraduate(String name, String address, String phoneNumber, String email,String grade, String study, String tutor) {
		super(name, address, phoneNumber, email, grade);
		this.study = study;
		this.tutor = tutor;
	}

	public String getStudy() {
		return study;
	}

	public String getTutor() {
		return tutor;
	}

	public void setStudy(String study) {
		this.study = study;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
}

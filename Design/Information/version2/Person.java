package version2;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;


@SuppressWarnings("serial")
public class Person implements Serializable {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
        
    public Person() {
    }

	public Person(String name,String address, String phoneNumber, String email){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void writeToFile(File f) throws FileNotFoundException, IOException {
		try(
				OutputStream os = new FileOutputStream(f,true);  
				BufferedOutputStream bos = new BufferedOutputStream(os);
				MyObjectOutputStream oos = MyObjectOutputStream.newInstance(f, bos);
			){
			oos.writeObject((Object)this);
		}
	}
	
	@Override
    public String toString() {
    	return "Person " + " 姓名: " + name;
    }
}

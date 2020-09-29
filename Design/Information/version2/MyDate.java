package version2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class MyDate implements Serializable{
	private int year;
    private int month;
    private int day;

    public MyDate() {
    }
    
    public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
    
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public void writeToFile(File f) throws FileNotFoundException, IOException {
		try(
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(f, true));){
			output.writeObject(this);
		}
	}
	
	@Override
    public String toString() {
		return "MyDate ";
    }
}

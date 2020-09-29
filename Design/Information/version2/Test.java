package version2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

public class Test {
	public static void main(String[] args) throws Exception {

		File file = new File("test2.dat");

		ArrayList<Person> persons = new ArrayList<Person>();

		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			int key = random.nextInt(6);
			Person person = new Person();
			switch (key) {
			case 0:
				person = new Person("ZhouMinghua", "ChongQing", "15123462120", "2731561576@qq.com");
				break;
			case 1:
				person = new Student("LiYou", "BiShan", "1562034820", "156225522@qq.com", "1");
				break;
			case 2:
				person = new Employee("HGDyd", "BeiJing", "52522555", "8848@qq.com", "4-151", "5000", 2000, 1, 15);
				break;
			case 3:
				person = new Staff("AAAA", "AAAA", "88888888", "55555@qq.com", "8-88", "8888", 1999, 9, 9, "教导主任");
				break;
			case 4:
				person = new Faculty("BBBB", "BBBB", "66666666", "6666@qq.com", "6-6", "66666", 1985, 8, 8, "8小时",
						"一级");
				break;
			case 5:
				person = new Postgraduate("CCCC", "CCCCC", "22222222", "222222@qq.com", "3", "软件工程", "zhangjingrong");
			default:
				break;
			}
			persons.add(person);
		}

		for (Person person : persons) {
			person.writeToFile(file);
		}
		ArrayList<Person> p = new ArrayList<Person>();
		p = printFile(new File("test2.dat"));
		printMessages(p);

	}

	public static void printMessages(ArrayList<Person> persons) throws Exception {
		System.out.println(persons.size());
		for (Person person : persons) {
			System.out.println(person);
		}
	}

	@SuppressWarnings("resource")
	public static ArrayList<Person> printFile(File f)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Person> persons = new ArrayList<Person>();
		ObjectInputStream input = new ObjectInputStream(new FileInputStream(f));
		try {
			while (true) {
				Person person = new Person();
				person = (Person) input.readObject();
				persons.add(person);
			}
		} catch (Exception e) {

		}
		return persons;

	}
}

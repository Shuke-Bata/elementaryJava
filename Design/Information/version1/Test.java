package version1;

import java.util.Random;

public class Test {
	
	public static void main(String[] args) {
		Person[] persons = new Person[5];
		
		Random random = new Random();
		for (int i = 0; i < persons.length; i++) {
			int key = random.nextInt(persons.length);
			switch (key) {
			case 0:
				persons[i] = new Person("ZhouMinghua", "ChongQing", "15123462120", "2731561576@qq.com");
				break;
			case 1:
				persons[i] = new Student("LiYou", "BiShan", "1562034820", "156225522@qq.com", 1);
				break;
			case 2:
				persons[i] = new Employee("HGDyd", "BeiJing", "52522555", "8848@qq.com", "4-151", 5000, 2000, 1, 15);
				break;
			case 3:
				persons[i] = new Staff("AAAA", "AAAA", "88888888", "55555@qq.com", "8-88", 8888, 1999, 9, 9, "教导主任");
				break;
			case 4:
				persons[i] = new Faculty("BBBB", "BBBB", "66666666", "6666@qq.com", "6-6", 66666, 1985, 8, 8, "8小时", "一级");
				break;
			default:
				break;
			}
		}
		printMessages(persons);
	}
	
	public static void printMessages(Person[] persons) {
		for (Person person : persons) {
			System.out.println(person.toString());
		}
	}
}

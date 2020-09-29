package chapter12.code;

import java.util.Scanner;

public class ReadFileFromURL12_17 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.print("Enter a URL: ");
		String URLString = new Scanner(System.in).next();
		
		try {
			java.net.URL url = new java.net.URL(URLString);
			int count = 0;
			Scanner inputScanner = new Scanner(url.openStream());
			while (inputScanner.hasNext()) {
				String line = inputScanner.nextLine();
				count += line.length();
			}
			
			System.out.println("The file size is " + count + " characters");
		} catch (java.net.MalformedURLException e) {
			System.out.println("Invalid URL");
		}
		catch (java.io.IOException e) {
			System.out.println("I/O Errors: no such file");
		}
	}
}

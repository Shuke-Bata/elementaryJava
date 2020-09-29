package version1;

import java.util.Random;
import java.util.Scanner;

/**
 * 随机产生一个单词，提示用户每次猜一个字母。
 * 单词中的每个字母以星号显示。
 * 当用户 猜对一个字母时，显示实际字母。
 * 当用户完成一个单词时，显示猜错的次数，同时询问用户 是否继续下一单词。
 * 
 * @version 1.0
 * @author 周明华
 *
 */
public class Game {
	Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Random random = new Random();
		
		String[] words = {"many", "experts", "call", "it", "the", "best",
				"personal", "computer", "apple", "system", "orange", "earth"};
		
		int key = 0;
		boolean continueGuess = true;
		
		Game game = new Game();
		while (continueGuess) {
			key = random.nextInt(words.length);//返回一个0(包括)到words.length(不包括)的随机整数
			int missedTimes = game.guessWord(words[key]);
			
			System.out.println("The word is: " + words[key] + ". You missed " + missedTimes
                    + ((missedTimes > 1) ? " times." : " time."));
		
			continueGuess = game.continueAnswer();
		}
		
		System.out.println("感谢您的使用!");
	}

	/**
	 * 猜单词的主要程序
	 * @param word 要猜的单词
	 * @return 猜错的次数
	 */
	private int guessWord(String word) {
		
		int missedTimes = 0;//输错的次数
		String str = new String();//存放字符串化的带*单词
		
		boolean complete = false;//单词的所有字母全部猜完
		boolean unfind = true;//猜的单词中是否存在输入的字母
		boolean existed = false;//输入的字母是否已经猜出
		
		char[] newWord =hideWord(word);//转换，要猜的单词用*表示
	
		while (complete == false) {
			unfind = true;
			existed = false;
			
			str = String.valueOf(newWord);
			
			if (str.equals(word)) {
				complete = true;
			}else {
				String string = new String();
				do {
					System.out.print("<Guess> Enter a letter in word " + str + " > ");
					 string = input.nextLine();
					if (checkInput(string)) {
						System.out.println("\t请输入单个字母!");
					}
				} while (checkInput(string));
				
				char answer = string.charAt(0);
				
				for (int i = 0; i < newWord.length; i++) {
					if (answer == newWord[i]) {
						existed = true;
						break;
					}
				}
				if (existed) {
					System.out.println("\t" + answer + " is already in the word.");
					missedTimes++;
				}
				
				for (int i = 0; i < word.length(); i++) {
					if (answer == word.charAt(i)) {
						unfind = false;
						newWord[i] = answer;//将所有匹配的字母替换，显示出来
					}
				}
				if (unfind) {
					System.out.println("\t" + answer + " is not in the word.");
					missedTimes++;
				}
			}
			
		}
		
		return missedTimes;
	}
	
	/**
	 * 将单词的每个字母转化成*表示
	 * @param word 要转化的单词
	 * @return *的字符数组
	 */
	private char[] hideWord(String word) {
		char[] newWord = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			newWord[i] = '*';
		}
		return newWord;
	}
	
	/**
	 * 是否继续猜单词？ 
	 * @return true 继续、false 退出
	 */
	private boolean continueAnswer() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		while(true) {
			String s = new String();
			do {
				System.out.print("Do you want to guess for another word? Enter y or n > ");
				s = input.next();
				if (checkInput(s)) {
					System.out.println("\t请输入单个字母!");
				}
			} while (checkInput(s));
			
			if (s.charAt(0) == 'n') {
				return false;
			}
			else if (s.charAt(0) == 'y') {
				return true;
			}
			else
				System.out.println("Invalid value.");
			}		
	}
	
	/**
	 * 检查输入是否为一个字母
	 * @param str
	 * @return false:单个字母
	 * 	true: 非单个字母
	 */
	private boolean checkInput(String str) {
		return str.length() == 1 ? false : true;
	}
}

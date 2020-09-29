package chapter06.code;

public class TestRandomCharacter6_11 {
	public static void main(String[] args) {
		final int NUMBER_OF_CHARS = 175;
		final int CHAR_PER_LINE = 25;

		for (int i = 0; i < NUMBER_OF_CHARS; i++) {
			char ch = RandomCharacter.getRandomLowerCaseLetter();
			if ((i + 1) % CHAR_PER_LINE == 0)
				System.out.println(ch);
			else
				System.out.print(ch);
		}
	}
}

class RandomCharacter {
	public static char getRandomCharacter(char ch1, char ch2) {
		return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
	}

	public static char getRandomLowerCaseLetter() {
		return getRandomCharacter('a', 'z');
	}

	public static char getRandomUpperCaseLetter() {
		return getRandomCharacter('A', 'Z');
	}

	public static char getRandomDigitCharacter() {
		return getRandomCharacter('0', '9');
	}

	public static char getRandomCharacter() {
		return getRandomCharacter('\u0000', '\uFFFF');
	}

}
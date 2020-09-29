package chapter06.code;

public class PrimeNumberMethod6_7 {
	public static void main(String[] args) {
		System.out.println("The first 50 prime numbers are \n");
		printPrimeNumber(50);
	}

	public static void printPrimeNumber(int number0fPrimes) {
		final int NUMBER_OF_PRIMES_LINE = 10;
		int count = 0;
		int number = 2;

		while (count < number0fPrimes) {
			if (isPrime(number)) {
				count++;
				if (count % NUMBER_OF_PRIMES_LINE == 0)
					System.out.format("%-5s\n", number);
				else
					System.out.printf("%-5s", number);
			}
			number++;
		}
	}

	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= number / 2; divisor++) {
			if (number % divisor == 0)
				return false;
		}
		return true;
	}

}

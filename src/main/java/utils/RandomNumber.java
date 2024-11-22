package utils;

public class RandomNumber {

	public static void main(String[] args) {

		int min = 50;
		int max = 100;

		// Generate random int value from 50 to 100
		System.out.println("Random value in int from " + min + " to " + max + ":");
		int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
		System.out.println(random_int);
	
	
	
	
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_0L;
		System.out.println("             "+number);
	}
}

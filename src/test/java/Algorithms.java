import java.util.Scanner;

public class Algorithms {

	public static void main(String[] args) {

		Algorithms al = new Algorithms();
		al.Algorithm("Hello");
		al.RevBuilder("Hello");
		al.Palindrome();

	}

	// By swapping chars
	public void Algorithm(String word) {
		// String word ="Vivek";
		String reversed = "";
		for (int i = 0; i < word.length(); i++) {
			char reverse = word.charAt(i);
			reversed = reverse + reversed;
		}
		System.out.println("Reversed string is " + reversed + "");
	}

	// Using String Builder
	public void RevBuilder(String wor) {
		StringBuilder str = new StringBuilder(wor);
		System.out.println("Reversed string using string builder:" + str.reverse());

	}

	// Palindrome
	public void Palindrome() {
		Boolean Checkpoint = true;
		while (Checkpoint) {
			String rev = "";
			Scanner sc = new Scanner(System.in);
			System.out.println("Entrer a word:\n");
			String str = sc.nextLine();
			for (int i = str.length() - 1; i >= 0; i--) {

				rev = rev + str.charAt(i);
			}
			if (str.equalsIgnoreCase(rev)) {

				System.out.println("The entered word is a palindrome: " + rev);
			} else {
				System.out.println("The entered word is not a palindrome: " + rev);
			}
			System.out.println("Do you want try another word? \n");
			String check = sc.nextLine();
			if (check.equalsIgnoreCase("yes")) {
				Checkpoint = true;
			} else {
				Checkpoint = false;
				System.out.println("Disconnecting, Have a good day!!");
			}

		}
	}

}


import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGameProject {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 20;
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int guess;
        int attempts = 0;

        System.out.println("Welcome To The Number Guessing Game!!! ");
        System.out.println("I am Picked a Number Betweem " + lowerBound + " and " + upperBound);

        try {
            do {
                System.out.println("Enter Your Guess::");
                guess = scan.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too Low ! Try again.");

                } else if (guess > randomNumber) {
                    System.out.println("Too High  ! Try again.");
                }

            } while (guess != randomNumber);
            System.out.println(
                    "Congratulation! You guessed the number " + randomNumber + "correctly in" + attempts + "attempts.");

        } catch (Exception e) {
            System.out.println("Enter a number! Characters are not allowed.");
        }
        scan.close();
    }
}

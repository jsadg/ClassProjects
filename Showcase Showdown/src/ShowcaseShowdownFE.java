/*
 * Jacob Stoll
 */
import java.util.Scanner;
public class ShowcaseShowdownFE {
	public static void main(String[] args) {
		ShowcaseShowdown game = new ShowcaseShowdown();
		Scanner scanner = new Scanner(System.in);
		boolean gameEnd = false;
		game.readFile("prizeFile.txt");
		System.out.println("Welcome to the Showcase Showdown!");
		while(!gameEnd) {
			try {
				System.out.println("Your prizes are: ");
				game.pickRandomPrizes();
				game.printPrizes();
				double value = game.getTotalValue();
				System.out.println("You must guess the total cost of the prizes without going over and within $1,300 of its actual price");
				System.out.println("Enter your guess:");
				double guess = scanner.nextDouble();
				if(guess>value) {
					game.printActualValue();
					System.out.println("Your guess was too high, you lose");
				}
				else if(guess <= 0) {
					game.printActualValue();
					System.out.println("It ain't free and we ain't paying you to take it either. You lose.");
				}
				else if(guess >= value-1300){
					game.printActualValue();
					System.out.println("YOU WIN!!!");
				}
				else {
					game.printActualValue();
					System.out.println("Your guess was too low, you lose");					
				}
				boolean playAgain = true;
				//Loops until the user chooses to quit or play again
				while(playAgain){
					try {
						System.out.println("Would you like to quit? Enter 0 to quit and 1 to continue");
						int choice = scanner.nextInt();
						if(choice == 0) {
							playAgain = false;
							gameEnd = true;
							System.out.println("Goodbye");
						}
						else if(choice == 1) {
							playAgain = false;
						}
						else {
							System.out.println("Enter one of the options");
						}
					}
					catch(Exception e){
						scanner.nextLine();
						System.out.println("Enter one of the options");
					}
				}
			}
			catch(Exception e) {
				System.out.println("Invalid guess entered");
				scanner.nextLine();
			}
		}
	}
}
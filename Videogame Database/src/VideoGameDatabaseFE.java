/*
 * Jacob Stoll
 */
import java.util.Scanner;
import java.io.*;
public class VideoGameDatabaseFE {	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String title = "";
		String console = "";
		boolean over = false;
		VideoGameDatabase database = new VideoGameDatabase();
		
		System.out.println("Welcome to the Video Database!");
		
		while(!over) {
			try {
				System.out.println("Enter 1 to load the database");
				System.out.println("Enter 2 to search the database");
				System.out.println("Enter 3 to print current results to the console");
				System.out.println("Enter 4 to print current results to a file");
				System.out.println("Enter 0 to quit");
				int choice = scanner.nextInt();
				scanner.nextLine();
				switch(choice) {
				//Switch to select an option based on the user's input
				case 0:
					over = true;
					break;
				case 1:
					//Reads the file that is inputed into the terminal
					System.out.println("Enter the name of the file you would like to add:");
					database.readGameFile(scanner.nextLine());
					break;
				case 2:
					//Prompts the user for a title and console to search the database for
					System.out.println("Enter the name of the game or '*' for all");
					title = scanner.nextLine().toUpperCase();
					System.out.println("Enter the name of the console or '*' for all");
					console = scanner.nextLine().toUpperCase();
					database.search(title,console);
					break;
				case 3:
					//If the database has been searched before return the list of previously searched items
					if(database.hasBeenSearched()) {
						database.getSearchList();
					}
					else {
						System.out.println("No results to print");
					}
					break;
				case 4:
					//Prompts the user for the file and writing type and then calls writeGameFile() appropriately
					boolean append = false;
					System.out.println("Write the name of the file you would like to write to");
					String fileName = scanner.nextLine();
					System.out.println("Type 'true' to append and 'false' to overwrite");
					append = scanner.nextBoolean();		
					System.out.println(append);
					if(database.hasBeenSearched()) {
						database.writeGameFile(fileName, append);
					}
					else {
						System.out.println("No results to write");
					}
					break;
				}
			}
			catch(Exception e){
				System.out.println("Invalid input");
			}
		}
		
	}

}

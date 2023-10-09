/*
 * Jacob Stoll
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class VideoGameDatabase {
	private static final String DELIM = "\t";
	private GenLL<Game> gameList;
	private GenLL<Game> searchList;
	boolean searched = false;
	
	//Constructor to initialize the two LLs
	public VideoGameDatabase() {
		gameList = new GenLL<Game>();
		searchList = new GenLL<Game>();
	}
	
	//Read the game file using a scanner, splits the line by tab and then records the data into gameList
	public void readGameFile(String aName) {
		try {
			Scanner fileScanner = new Scanner(new File(aName));
			while(fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();
				String[] splitLine = fileLine.split(DELIM);
				if(splitLine.length !=2) {
					continue;
				}
				String title = splitLine[0];
				String console = splitLine[1];
				Game newGame = new Game(title, console);
				gameList.add(newGame);
			}
			fileScanner.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*Iterates through game list and finds if the entered information is contained in the title or console of the game
	 * if a '*' is used then it uses it as a wildcard. notFound is also kept track of to see if the user 
	 * actually finds games, otherwise it prints out no matches found.
	 */
	public void search(String title, String console) {
		searched = true;
		boolean notFound = true;
		searchList.clearList();
		gameList.reset();
		while(gameList.hasMore()) {
			if(title.equals("*") && console.equals("*")) {
				System.out.println(gameList.getCurrent());
				searchList.add(gameList.getCurrent());
				notFound = false;
			}
			else if(title.equals("*") && gameList.getCurrent().getConsole().toUpperCase().contains(console)) {
				System.out.println(gameList.getCurrent());
				searchList.add(gameList.getCurrent());
				notFound = false;
			}
			else if(gameList.getCurrent().getTitle().toUpperCase().contains(title) && console.equals("*")) {
				System.out.println(gameList.getCurrent());
				searchList.add(gameList.getCurrent());
				notFound = false;
			}
			else if(gameList.getCurrent().getTitle().toUpperCase().contains(title) && gameList.getCurrent().getConsole().toUpperCase().contains(console)) {
				System.out.println(gameList.getCurrent());	
				searchList.add(gameList.getCurrent());
				notFound = false;
			}				
			gameList.gotoNext();
		}
		if(notFound) {
			System.out.println("No matches found");
		}
	}
	//Writes to a given file by printing out searchList to it
	public void writeGameFile(String aN, boolean append) {
		try {
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream((aN), append));
			searchList.reset();
			while(searchList.hasMore()) {
				fileWriter.println(searchList.getCurrent());
				searchList.gotoNext();
			}
			fileWriter.close();
		}
		catch(Exception e) {
			System.out.println("File output error");
		}
	}
	
	//Used to keep track of the database has been searched
	public boolean hasBeenSearched() {
		return searched;
	}
	
	//Used when printing out searchList
	public void getSearchList() {
		searchList.print();
	}
	

}
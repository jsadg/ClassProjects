/*
 * Jacob Stoll
 */
import java.util.*;
import java.io.*;
public class ShowcaseShowdown {
	public static final String DELIM = "\t";
	public static final int PRIZE_FIELD_AMT = 2;
	private Prize[] prizeList;
	private Prize[] randomPrizes;
	
	//Gets the number of valid prizes in the file through reading it and looking for properly inputed prizes
	public int getNumLines(String aName) {
		try {
			int numLines = 0;
			Scanner fileScanner = new Scanner(new File(aName));
			while(fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();
				String splitLine[] = fileLine.split(DELIM);
				if(splitLine.length != PRIZE_FIELD_AMT) {
					continue;
				}
				else {
					numLines++;
				}
				
			}
			fileScanner.close();
			return numLines;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	/*Reads the inputed file and creates an array to hold all the valid prizes in it; The method calls 
	 * getNumLines()in order to construct the right size for the array, then reads line by line separating each 
	 * prize's name and price through splitting where tabs are. When it is finished it sets prizeList 
	 * equal to the constructed array to transfer all of the values.
	 */
	public void readFile(String aName) {
		try {
			int index = 0;
			Prize[] prizes = new Prize[getNumLines(aName)];
			Scanner fileScanner = new Scanner(new File(aName));
			while(fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();
				String splitLine[] = fileLine.split(DELIM);
				if(splitLine.length != PRIZE_FIELD_AMT) {
					continue;
				}
				String name = splitLine[0];
				int price = Integer.parseInt(splitLine[1]);
				Prize newPrize = new Prize(name, price);
				prizes[index] = newPrize; 
				index++;
			}
			fileScanner.close();
			prizeList = prizes;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//This method creates an array of 5 random prizes without duplicates then assigns it to randomPrizes.
	public void pickRandomPrizes() {
		Prize[] randomP = new Prize[5];
		for(int i=0;i<5;i++) {
			boolean duplicate = false;
			int index = (int)(Math.random()*prizeList.length);
			for(int j=0;j<5;j++) {
				if(prizeList[index].equals(randomP[j])) {
					duplicate = true;
					break;
				}
			}
			if(duplicate) {
				i--;
			}
			else {
				randomP[i] = prizeList[index];
			}
		}
		randomPrizes = randomP;
	}
	
	//This method iterates through randomPrizes and prints out each one
	public void printPrizes() {
		for(int i=0;i<randomPrizes.length;i++) {
			System.out.println(randomPrizes[i]);
		}
	}
	
	//This method iterates through randomPrizes and adds up all of their prices to return
	public double getTotalValue() {
		double total = 0;
		for(int i=0;i<randomPrizes.length;i++) {
			total += randomPrizes[i].getPrice();
		}
		return total;
	}
	
	//This method prints out what was the target value to guess
	public void printActualValue() {
		System.out.println("The actual price was "+getTotalValue());
	}
	
}

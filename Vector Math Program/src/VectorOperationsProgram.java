/*
 * Jacob Stoll
 */
import java.util.Scanner;

public class VectorOperationsProgram {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[]) {
		boolean end = false;
		System.out.println("Welcome to the Vectors Operation Program");
		while(!end) {
			/*This try catch prevents the program from ending when the user 
			 * tries to submit an invalid option.
			 */
			try {
				System.out.println("Enter 1 to add two vectors");
				System.out.println("Enter 2 to add subtract two vectors");
				System.out.println("Enter 3 to find the magnitude of a vector");
				System.out.println("Enter 4 to quit the program");
				int choice = scanner.nextInt();
				/*This try catch handles any errors from invalid vector data for
				 * the first three options and prevents the program from ending.
				 */
				try {
					if(choice==1){
						vectorArithmetic(1);
					}
					else if(choice==2) {
						vectorArithmetic(-1);
					}
					else if(choice==3) {
						vectorMagnitude();
					}		
				}
				catch(Exception e){
					scanner.nextLine();
					System.out.println("Invalid vector information, please try again");
				}
				if(choice==4) {
					/*When this choice is selected, the while loop condition is
					 * set to false so the program ends.
					 */
					end=true;
					System.out.println("Thank you for using the Vectors Operation Program");
					System.out.println("Goodbye");
				}	
				//Handles integer choices that are not options
				else if(choice >= 5 || choice <=0){
					System.out.println("You did not select a valid option, please try again");
				}
			}
			catch(Exception e){
				scanner.nextLine();
				System.out.println("You did not select a valid option, please try again");
			}	
		}
	}
	/*
	 * This method prompts the user for the data for each term of a vector.
	 * The final vector is then returned.
	 */
	public static double[] getVectorData(int nT, int which) {
		double[] vector = new double[nT];
		//The inclusion of which is to help differentiate between multiple vectors 
		System.out.println("Enter the value(s) for vector "+which);
		for(int i=0;i<nT;i++) {
			vector[i] = scanner.nextDouble();
		}
		return vector;
	}
	/*
	 * This method prompts the user for the size of 2 vectors, and calls 
	 * getVectorData() to get each vectors' terms. The second vector is 
	 * multiplied by 1 or -1 to represent addition or subtraction respectively. 
	 * The two are then added together, stored in ans[], and the result is 
	 * printed out by calling printVector(). Invalid vector lengths are 
	 * accounted for and result in the user returning to the main menu.
	 */
	public static void vectorArithmetic(int addOrSub) {
		System.out.println("Enter the size of the two vectors");
		int size = scanner.nextInt();
		if(size>=1) {
			double[] vector1 = getVectorData(size,1);
			double[] vector2 = getVectorData(size,2);	
			double[] ans = new double[size];
			for(int i=0;i<size;i++) {
				ans[i] = vector1[i] + (vector2[i]*addOrSub);
			}
			printVector(ans);
		}
		else {
			System.out.println("Invalid vector length");
		}
	}
	/*
	 * This method prompts the user for the size of a vector, then calls
	 * getVectorData() to get its terms. Each term is multiplied by itself
	 * and the result is added to the double sum. After all the terms have
	 * been added, the square root of sum is printed out. Invalid vector 
	 * sizes result in the user returning to the main menu.
	 */
	public static void vectorMagnitude() {
		System.out.println("Enter the size of the vector");
		int size = scanner.nextInt();
		if(size>=1) {
			double[] vector1 = getVectorData(size,1);
			double sum = 0;
			for(int i=0;i<vector1.length;i++) {
				sum+=Math.pow(vector1[i],2);
			}
			System.out.println("The magnitude of the vector is "+Math.sqrt(sum));
		}
		else {
			System.out.println("Invalid vector size");
		}
	}
	// This method prints out each term of a vector to the terminal.
	public static void printVector(double vector[]) {
		if(vector.length>=1) {
			System.out.println("Your answer is:");
			for(int i=0;i<vector.length;i++) {
				System.out.println(vector[i]);
			}
		}
	}
}
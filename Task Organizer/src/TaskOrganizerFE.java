/*
 * Jacob Stoll
 */
import java.util.Scanner;
public class TaskOrganizerFE {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TaskOrganizer taskOrg = new TaskOrganizer();
		boolean end = false;
		int priority;
		String action;
		System.out.println("Welcome to the Task Organizer");
		
		while(!end) {
			try {
				System.out.println("Enter 1 to add a task");
				System.out.println("Enter 2 to remove a task");
				System.out.println("Enter 3 to print tasks to console");
				System.out.println("Enter 4 to read from a task file");
				System.out.println("Enter 5 to write to a task file");
				System.out.println("Enter 9 to quit");
				int choice = scanner.nextInt();
				scanner.nextLine();
				switch(choice) {
					case 1:
						System.out.println("What is the priority of the task to add?");
						priority = Integer.parseInt(scanner.nextLine());
						System.out.println("What is the action of the task to add?");
						action = scanner.nextLine();
						taskOrg.addTask(priority, action);
						break;
					case 2:
						System.out.println("What is the priority of the task to remove?");
						priority = Integer.parseInt(scanner.nextLine());
						System.out.println("What is the action of the task to remove?");
						action = scanner.nextLine();
						taskOrg.removeTask(priority, action);
						break;
					case 3:
						taskOrg.printTasks();
						break;
					case 4:
						System.out.println("What is the file to read?");
						taskOrg.readTaskFile(scanner.nextLine());
						break;
					case 5:
						System.out.println("What is the file to write to?");
						taskOrg.printTaskFile(scanner.nextLine());
						break;
					case 9:
						System.out.println("Goodbye");
						end = true;
						break;
					default:
						System.out.println("Invalid option selected");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Invalid priority or task inputed");
			}
		}	
	}
}

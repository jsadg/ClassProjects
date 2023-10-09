/*
 * Jacob Stoll
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskOrganizer {
	GenLL<Task>[] organizedTasks;
	//Creates the array of linked lists
	public TaskOrganizer() {
		organizedTasks = new GenLL[5];
		for(int i=0;i<organizedTasks.length;i++)
		{
			organizedTasks[i] = new GenLL<Task>();
		}
	}
	//Checks to see if a task is valid and not already listed then adds it to the correct list
	public void addTask(int prio, String action) {
		if(prio > 5 || prio < 0) {
			System.out.println("Invalid priority selected");
			return;
		}
		Task task = new Task(prio, action);
		if(!(organizedTasks[prio].alreadyListed(task))) {
			organizedTasks[prio].add(task);
			System.out.println(task +" added successfully");

		}
		else {
			System.out.println("The task is already present");
		}
	}
	//Checks to see if a task is already listed then removes it from the correct list	
	public void removeTask(int prio, String action) {
		if(prio > 5 || prio < 0) {
			System.out.println("Invalid priority selected");
			return;
		}
		Task task = new Task(prio, action);
		if(organizedTasks[prio].alreadyListed(task)) {
			organizedTasks[prio].remove(task);
			System.out.println(task +" removed successfully");
		}
		else {
			System.out.println("The task is already not present");
		}
	}
	//Prints out all of the tasks from all of the lists
	public void printTasks() {
		for(int i=0;i<5;i++) {
			organizedTasks[i].print();
		}
	}
	//Clears out the current task file and then loads a new one given by a user
	public void readTaskFile(String aName) {
		try {
			resetTasks();
			Scanner fileScanner = new Scanner(new File(aName));
			while(fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();
				String[] splitLine = fileLine.split("\t");
				if(splitLine.length !=2) {
					continue;
				}
				int priority = Integer.parseInt(splitLine[0]);
				String action = splitLine[1];
				addTask(priority, action);
			}
			fileScanner.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//Clears all the tasks in all of the lists
	public void resetTasks() {
		for(int i=0;i<5;i++) {
			organizedTasks[i].clearList();
		}
	}
	//Prints the current task list to a given file
	public void printTaskFile(String aN) {
		try {
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aN));
			for(int i=0;i<5;i++) {
				while(organizedTasks[i].hasMore()) {
					fileWriter.println(organizedTasks[i].getCurrent());
					organizedTasks[i].gotoNext();
				}
			}
			fileWriter.close();
		}
		catch(Exception e) {
			System.out.println("File output error");
		}
	}
	
}

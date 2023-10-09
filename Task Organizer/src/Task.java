/*
 * Jacob Stoll
 */
public class Task {
	private int priority;
	private String action;
		
	public Task(int prio, String action) {
		this.priority = prio;
		this.action = action;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	//Used to check for equality in the alreadyListed() method
	public boolean equals(Task task) {
		return this.action.equals(task.getAction()) && this.priority == task.getPriority();
	}
	//Prints out the task's priority and action when a task is printed
	public String toString() {
		return "[Task] Priority: "+priority + " Task: "+action;
	}
	
	
	
}

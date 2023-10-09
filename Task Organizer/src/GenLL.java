/*
 * Jacob Stoll
 */
public class GenLL <T>{
	private class ListNode{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	private ListNode head;
	private ListNode current;
	private ListNode previous;
	
	public GenLL() {
		head = current = previous = null;
	}
	//Used to add a task to the list when addTask() is called and the task is not already listed with valid priority
	public void add(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if(head == null) {
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.link != null) {
			temp = temp.link;
		}
		temp.link = newNode;
	}
	
	public void print() {
		ListNode temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	//Moves to the next node in the list
	public void gotoNext() {
		if(current == null) {
			return;
		}
		previous = current;
		current = current.link;
	}
	
	//Used to remove a task when removeTask() is given a task that exists
	public void remove(Task task) {
		current = head;
		while(hasMore()) {
			if(task.equals((Task)current.data)) {
				if(current.equals(head)) {
					head = head.link;
					break;
				}
				previous.link = current.link;
				current = current.link;	
				break;
			}
			gotoNext();
		}
	}
	//Clears the entire list
	public void clearList() {
		current = head = previous = null;
	}
	//Checks to see if a task is already present in the list
	public boolean alreadyListed(Task task) {
		ListNode temp = head;
		while(temp != null) {
			if(task.equals((Task)temp.data)) {
				return true;
			}
			temp = temp.link;
		}
		return false;
	}
	//Checks to see if the linked list has more values
	public boolean hasMore() {
		return current != null;
	}
	//Returns the current task information
	public T getCurrent() {
		if(current != null) {
			return current.data;
		}
		return null;
	}
	

	
	
}
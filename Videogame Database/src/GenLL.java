/*
 * Jacob Stoll
 */
public class GenLL <T> {
	public class ListNode {
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	private ListNode head;
	private ListNode current;
	public GenLL() {
		head = current = null;
	}
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
	
	public T getCurrent() {
		if(current != null) {
			return current.data;
		}
		return null;
	}
	
	public void gotoNext() {
		if(current == null) {
			return;
		}
		current = current.link;
	}
	
	public void reset() {
		current = head;
	}
	

	public void clearList() {
		current = head = null;
	}
	
	
	public boolean hasMore() {
		return current != null;
	}
		

		
	
	
	
	
}

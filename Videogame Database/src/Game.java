/*
 * Jacob Stoll
 */
public class Game {
	private String title;
	private String console;
	
	public Game(String aT, String aC) {
		this.title = aT;
		this.console = aC;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}
	
	public String toString() {
		return this.title+"\t"+this.console;
	}
	
	
	
	
}

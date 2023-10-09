/*
 * Jacob Stoll
 */
public class Prize {
	private String name;
	private double price;
	
	public Prize(String aN, double aP) {
		this.setName(aN);
		this.setPrice(aP);
	}

	public void setName(String aN) {
		this.name = aN;
	}
	
	public void setPrice(double aP){
		this.price = aP;
	}

	public double getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean equals(Prize aP) {
		return aP != null && this.name.equals(aP.getName()) && this.price == aP.getPrice();
	}
	
	public String toString() {
		return this.name;
	}
	
}
package structures;

public class PublicTrade {
	int id;
	double price;
	double quantity;
	Boolean side;
	String timestamp;
	public PublicTrade(int id, double price, double quantity, String side, String timestamp) {
		System.out.println("In constructor: "+ side);
	
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.side = (side.toUpperCase().equals("BUY") ? true : false);
		this.timestamp = timestamp;
	}

	/*
	 * Constructors;
	 */
	public PublicTrade(int id, double price, double quantity, boolean side, String timestamp) {
		System.out.println("In constructor: "+ side);

		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.side = side;
		this.timestamp = timestamp;
	}
	
	/*
	 * Getters
	 */
	public int getId() {
		return id;
	}
	public double getPrice() {
		return price;
	}
	public double getQuantity() {
		return quantity;
	}
	public boolean isBuy() {
		return side;
	}
	public boolean isSell() {
		return !side;
	}
	public String getTimestamp() {
		return timestamp;
	}
	/*
	 * Setters
	 */
	public void setId(int id) {
		this.id = id;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public void setSide(String side) {
		System.out.println("In setter: "+ side);
		this.side= (side.toUpperCase().equals("BUY")? true : false);
	}
	public void setBuy(boolean side) {
		this.side = side;
	}
	public void setSell(boolean side) {
		this.side= !side;
	}
	public void setBuy() {
		this.side= true;
	}
	public void setSell() {
		this.side= false;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/*
	 * The rest
	 */
	public void Info() {
		System.out.println(id + " Price:"+ price + " Quantity:" + quantity + (side ? " -Buy" : " -Sell"));
	}
}

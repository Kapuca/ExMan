package structures;

public class Balance{
	public String currency;
	public double available;
	public double reserved;
	/*
	 * Constructors
	 */
	public Balance(String currency, double available, double reserved) {
		this.currency = currency;
		this.available = available;
		this.reserved = reserved;
	}
	/*
	 * Getters
	 */
	public String getCurrency() {
		return currency;
	}
	public double getAvailable() {
		return available;
	}
	public double getReserved() {
		return reserved;
	}
	/*
	 * Setters
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setAvailable(double available) {
		this.available = available;
	}
	public void setReserved(double reserved) {
		this.reserved = reserved;
	}
	/*
	 * The rest
	 */
	public double getTotal() {
		return this.available + this.reserved;
	}
	public void Info() {
		System.out.println("--"+this.currency+"\nAva:"+ this.available+"\nRes:"+this.reserved);
	}

}

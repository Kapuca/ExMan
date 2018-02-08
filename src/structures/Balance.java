package structures;

public class Balance{
	public String currency;
	public double available;
	public double reserved;
	
	public Balance(String currency, String available, String reserved) {
		this.currency= currency;
		this.available= Double.valueOf(available);
		this.reserved= Double.valueOf(reserved);
	}
	public void Info() {
		System.out.println("--"+this.currency+"\nAva:"+ this.available+"\nRes:"+this.reserved);
	}
}

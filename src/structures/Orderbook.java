package structures;

import java.util.List;

public class Orderbook {
	List<Offer> ask;
	List<Offer> bid;
	/*
	 * constructors
	 */
	public Orderbook(List<Offer> ask, List<Offer> bid) {
		this.ask = ask;
		this.bid = bid;
	}
	/*
	 * Getters
	 */
	public List<Offer> getAsk() {
		return ask;
	}
	public List<Offer> getBid() {
		return bid;
	}
	/*
	 * Setters
	 */
	public void setAsk(List<Offer> ask) {
		this.ask = ask;
	}
	public void setBid(List<Offer> bid) {
		this.bid = bid;
	}
	/*
	 * The rest
	 */
	public void Info() {
		System.out.println("Asks:");
		for (Offer offer : ask) offer.Info();
		System.out.println("Bids:");
		for (Offer offer : bid) offer.Info();
	}
}
class Offer{
	double price;
	double size;
	/*
	 * Constructors
	 */
	public Offer(double price, double size) {
		this.price = price;
		this.size = size;
	}
	/*
	 * Getters
	 */
	public double getPrice() {
		return price;
	}
	public double getSize() {
		return size;
	}
	/*
	 * Setters
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	public void setSize(double size) {
		this.size = size;
	}
	/*
	 * The rest
	 */
	public void Info() {
		System.out.println("Price:" + price + " Size:" + size);	
	}
	
}
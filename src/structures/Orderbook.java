package structures;

import java.math.BigDecimal;
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
	BigDecimal price;
	BigDecimal size;
	/*
	 * Constructors
	 */
	public Offer(BigDecimal price, BigDecimal size) {
		this.price = price;
		this.size = size;
	}
	/*
	 * Getters
	 */
	public BigDecimal getPrice() {
		return price;
	}
	public BigDecimal getSize() {
		return size;
	}
	/*
	 * Setters
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setSize(BigDecimal size) {
		this.size = size;
	}
	/*
	 * The rest
	 */
	public void Info() {
		System.out.println("Price:" + price + " Size:" + size);	
	}
	
}
package structures;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ticker {
	String symbol;
	double ask;
	double bid;
	double last;
	double open;
	double low;
	double high;
	double volume;
	double volumeQuote;
	String timestamp;
	/*
	 * Constructors
	 */
	public Ticker(String symbol, double ask, double bid,
				double last, double open, double low,
				double high, double volume, double volumeQuote, String timestamp) {
		this.symbol= symbol;
		this.ask= ask;
		this.bid= bid;
		this.last= last;
		this.open= open;
		this.low= low;
		this.high= high;
		this.volume= volume;
		this.volumeQuote= volumeQuote;
		this.timestamp= timestamp;
	}
	public Ticker(String symbol, String ask, String bid,
			String last, String open, String low,
			String high, String volume, String volumeQuote, String timestamp) {
		this(symbol, Double.valueOf(ask), Double.valueOf(bid), Double.valueOf(last),
			Double.valueOf(open), Double.valueOf(low), Double.valueOf(high),
			Double.valueOf(volume), Double.valueOf(volumeQuote), timestamp);
	}
	public Ticker() {
		this(null, 0, 0, 0, 0, 0, 0, 0, 0, null);
	}
	/*
	 * Getters
	 */
	public String getSymbol() {
		return symbol;
	}
	public double getAsk() {
		return ask;
	}
	public double getBid() {
		return bid;
	}
	public double getLast() {
		return last;
	}
	public double getOpen() {
		return open;
	}
	public double getLow() {
		return low;
	}
	public double getHigh() {
		return high;
	}
	public double getVolume() {
		return volume;
	}
	public double getVolumeQuote() {
		return volumeQuote;
	}
	public String getTimestamp() {
		return timestamp;
	}
	/*
	 * Setters
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public void setAsk(double ask) {
		this.ask = ask;
	}
	public void setBid(double bid) {
		this.bid = bid;
	}
	public void setLast(double last) {
		this.last = last;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public void setVolumeQuote(double volumeQuote) {
		this.volumeQuote = volumeQuote;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/*
	 * The rest
	 */
	public double getMargin() {
		return this.ask - this.bid;
	}
	public double getChange() {
		BigDecimal bd = new BigDecimal(this.last*100/this.open-100);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

		
}

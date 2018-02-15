package structures;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ticker {
	String symbol;
	BigDecimal ask;
	BigDecimal bid;
	BigDecimal last;
	BigDecimal open;
	BigDecimal low;
	BigDecimal high;
	BigDecimal volume;
	BigDecimal volumeQuote;
	String timestamp;
	/*
	 * Constructors
	 */
	public Ticker(String symbol, BigDecimal ask, BigDecimal bid,
				BigDecimal last, BigDecimal open, BigDecimal low,
				BigDecimal high, BigDecimal volume, BigDecimal volumeQuote, String timestamp) {
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
	
	public Ticker() {
		this(null, null, null, null, null, null, null, null, null, null);
	}
	/*
	 * Getters
	 */
	public String getSymbol() {
		return symbol;
	}
	public BigDecimal getAsk() {
		return ask;
	}
	public BigDecimal getBid() {
		return bid;
	}
	public BigDecimal getLast() {
		return last;
	}
	public BigDecimal getOpen() {
		return open;
	}
	public BigDecimal getLow() {
		return low;
	}
	public BigDecimal getHigh() {
		return high;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public BigDecimal getVolumeQuote() {
		return volumeQuote;
	}
	public String getTimestamp() {
		return timestamp;
	}
	//Extra
	public BigDecimal getDiff(BigDecimal open, BigDecimal close) {
		return close.subtract(open);
	}
	public BigDecimal getPecent(BigDecimal open, BigDecimal close) {
		try {
			return close.multiply(BigDecimal.valueOf(100))
					.divide(open, 2, RoundingMode.HALF_UP)
					.subtract(BigDecimal.valueOf(100));
		} catch (Exception e) {
			return null;
		}

	    
	}
	
	public BigDecimal getMargin(boolean percent) {
		if (percent) return getPecent(this.bid, this.ask);
		return getDiff(this.bid, this.ask);
	}
	public BigDecimal getChange(boolean percent) {
		if (percent) return getPecent(this.open, this.last);
		return getDiff(this.open, this.last);
	}
	/*
	 * Setters
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}
	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}
	public void setLast(BigDecimal last) {
		this.last = last;
	}
	public void setOpen(BigDecimal open) {
		this.open = open;
	}
	public void setLow(BigDecimal low) {
		this.low = low;
	}
	public void setHigh(BigDecimal high) {
		this.high = high;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	public void setVolumeQuote(BigDecimal volumeQuote) {
		this.volumeQuote = volumeQuote;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/*
	 * The rest
	 */
	public void Info() {
		System.out.println(symbol+ " " + getChange(true) + "% Margin:"+(bid!=null && ask!=null ? getMargin(true) : "--") + "%");
	}



		
}

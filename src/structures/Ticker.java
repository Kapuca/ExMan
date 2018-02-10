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
	
	public String getSymbol() {
		return this.symbol;
	}
	public double getOpen() {
		return this.open;
	}
	public double getLast() {
		return this.last;
	}
	public double getMargin() {
		return this.ask - this.bid;
	}
	public double getChange() {
		BigDecimal bd = new BigDecimal(this.last*100/this.open-100);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

		
}

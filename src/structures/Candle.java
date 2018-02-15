package structures;

import java.math.BigDecimal;

public class Candle {
	String timestamp;
    BigDecimal open;
    BigDecimal close;
    BigDecimal min;
    BigDecimal max;
    BigDecimal volume;
    BigDecimal volumeQuote;
    /*
     * Constructors
     */
	public Candle(String timestamp, BigDecimal open, BigDecimal close, BigDecimal min, BigDecimal max, BigDecimal volume,
			BigDecimal volumeQuote) {
		this.timestamp = timestamp;
		this.open = open;
		this.close = close;
		this.min = min;
		this.max = max;
		this.volume = volume;
		this.volumeQuote = volumeQuote;
	}
    /*
     * Getters
     */
	public String getTimestamp() {
		return timestamp;
	}
	public BigDecimal getOpen() {
		return open;
	}
	public BigDecimal getClose() {
		return close;
	}
	public BigDecimal getMin() {
		return min;
	}
	public BigDecimal getMax() {
		return max;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public BigDecimal getVolumeQuote() {
		return volumeQuote;
	}
	/*
	 * Setters
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public void setOpen(BigDecimal open) {
		this.open = open;
	}
	public void setClose(BigDecimal close) {
		this.close = close;
	}
	public void setMin(BigDecimal min) {
		this.min = min;
	}
	public void setMax(BigDecimal max) {
		this.max = max;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	public void setVolumeQuote(BigDecimal volumeQuote) {
		this.volumeQuote = volumeQuote;
	}
	/*
	 * The rest
	 */
	public void Info() {
		System.out.println(timestamp+ " Open:"+ open + " Close:"+ close );
	}
	
}

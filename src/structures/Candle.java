package structures;

public class Candle {
	String timestamp;
    double open;
    double close;
    double min;
    double max;
    double volume;
    double volumeQuote;
    /*
     * Constructors
     */
	public Candle(String timestamp, double open, double close, double min, double max, double volume,
			double volumeQuote) {
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
	public double getOpen() {
		return open;
	}
	public double getClose() {
		return close;
	}
	public double getMin() {
		return min;
	}
	public double getMax() {
		return max;
	}
	public double getVolume() {
		return volume;
	}
	public double getVolumeQuote() {
		return volumeQuote;
	}
	/*
	 * Setters
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public void setVolumeQuote(double volumeQuote) {
		this.volumeQuote = volumeQuote;
	}
	/*
	 * The rest
	 */
	public void Info() {
		System.out.println(timestamp+ " Open:"+ open + " Close:"+ close );
	}
	
}

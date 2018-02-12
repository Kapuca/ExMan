package structures;

public class Pair {
	String id;
	String baseCurrency;
	String quoteCurrency;
	double quantityIncrement;
	double tickSize;
	double takeLiquidityRate;
	double provideLiquidityRate;
	String feeCurrency;
	/*
	 * Constrictors
	 */
	public Pair(String id, String baseCurrency, String quoteCurrency, double quantityIncrement, double tickSize,
			double takeLiquidityRate, double provideLiquidityRate, String feeCurrency) {
		this.id = id;
		this.baseCurrency = baseCurrency;
		this.quoteCurrency = quoteCurrency;
		this.quantityIncrement = quantityIncrement;
		this.tickSize = tickSize;
		this.takeLiquidityRate = takeLiquidityRate;
		this.provideLiquidityRate = provideLiquidityRate;
		this.feeCurrency = feeCurrency;
	}


	public Pair() {
		this(null, null, null, 0, 0, 0, 0, null);
	}
	/*
	 * Getters
	 */
	public String getId() {
		return id;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public String getQuoteCurrency() {
		return quoteCurrency;
	}
	public double getQuantityIncrement() {
		return quantityIncrement;
	}
	public double getTickSize() {
		return tickSize;
	}
	public double getTakeLiquidityRate() {
		return takeLiquidityRate;
	}
	public double getProvideLiquidityRate() {
		return provideLiquidityRate;
	}
	public String getFeeCurrency() {
		return feeCurrency;
	}
	/*
	 * Setters
	 */
	public void setId(String id) {
		this.id = id;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public void setQuoteCurrency(String quoteCurrency) {
		this.quoteCurrency = quoteCurrency;
	}
	public void setQuantityIncrement(double quantityIncrement) {
		this.quantityIncrement = quantityIncrement;
	}
	public void setTickSize(double tickSize) {
		this.tickSize = tickSize;
	}
	public void setTakeLiquidityRate(double takeLiquidityRate) {
		this.takeLiquidityRate = takeLiquidityRate;
	}
	public void setProvideLiquidityRate(double provideLiquidityRate) {
		this.provideLiquidityRate = provideLiquidityRate;
	}
	public void setFeeCurrency(String feeCurrency) {
		this.feeCurrency = feeCurrency;
	}

	/*
	 * The rest
	 */
	public void Info(){
		System.out.println("Trading pair: "+ this.baseCurrency+"/"+this.quoteCurrency+
							"\nMin buy: "+ this.quantityIncrement);
	}
	
}



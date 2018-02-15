package structures;

import java.math.BigDecimal;

public class Pair {
	String id;
	String baseCurrency;
	String quoteCurrency;
	BigDecimal quantityIncrement;
	BigDecimal tickSize;
	BigDecimal takeLiquidityRate;
	BigDecimal provideLiquidityRate;
	String feeCurrency;
	/*
	 * Constrictors
	 */
	public Pair(String id, String baseCurrency, String quoteCurrency, BigDecimal quantityIncrement, BigDecimal tickSize,
			BigDecimal takeLiquidityRate, BigDecimal provideLiquidityRate, String feeCurrency) {
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
		this(null, null, null, null, null, null, null, null);
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
	public BigDecimal getQuantityIncrement() {
		return quantityIncrement;
	}
	public BigDecimal getTickSize() {
		return tickSize;
	}
	public BigDecimal getTakeLiquidityRate() {
		return takeLiquidityRate;
	}
	public BigDecimal getProvideLiquidityRate() {
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
	public void setQuantityIncrement(BigDecimal quantityIncrement) {
		this.quantityIncrement = quantityIncrement;
	}
	public void setTickSize(BigDecimal tickSize) {
		this.tickSize = tickSize;
	}
	public void setTakeLiquidityRate(BigDecimal takeLiquidityRate) {
		this.takeLiquidityRate = takeLiquidityRate;
	}
	public void setProvideLiquidityRate(BigDecimal provideLiquidityRate) {
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



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
	
	public Pair(String id, String baseCurrency, String quoteCurrency, String quantityIncrement, String tickSize, String takeLiquidityRate, String provideLiquidityRate, String feeCurrency){
		this.id= id;
		this.baseCurrency= baseCurrency;
		this.quoteCurrency= quoteCurrency;
		this.quantityIncrement= Double.valueOf(quantityIncrement);
		this.tickSize= Double.valueOf(tickSize);
		this.takeLiquidityRate= Double.valueOf(takeLiquidityRate);
		this.provideLiquidityRate= Double.valueOf(provideLiquidityRate);
		this.feeCurrency= feeCurrency;
		
	}
	public Pair(String id, String baseCurrency, String quoteCurrency, double quantityIncrement, double tickSize, double takeLiquidityRate, double provideLiquidityRate, String feeCurrency){
		this.id= id;
		this.baseCurrency= baseCurrency;
		this.quoteCurrency= quoteCurrency;
		this.quantityIncrement= quantityIncrement;
		this.tickSize= tickSize;
		this.takeLiquidityRate= takeLiquidityRate;
		this.provideLiquidityRate= provideLiquidityRate;
		this.feeCurrency= feeCurrency;
		
	}
	public Pair() {
		this(null, null, null, 0, 0, 0, 0, null);
	}
	public void Info(){
		System.out.println("Trading pair: "+ this.baseCurrency+"/"+this.quoteCurrency+
							"\nMin buy: "+ this.quantityIncrement);
	}
}


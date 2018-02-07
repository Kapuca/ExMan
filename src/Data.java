
public class Data{
	
}

class Symbol {
	String id;
	String baseCurrency;
	String quoteCurrency;
	double quantityIncrement;
	double tickSize;
	double takeLiquidityRate;
	double provideLiquidityRate;
	String feeCurrency;
	
	public Symbol(String id, String baseCurrency, String quoteCurrency, String quantityIncrement, String tickSize, String takeLiquidityRate, String provideLiquidityRate, String feeCurrency){
		this.id= id;
		this.baseCurrency= baseCurrency;
		this.quoteCurrency= quoteCurrency;
		this.quantityIncrement= Double.valueOf(quantityIncrement);
		this.tickSize= Double.valueOf(tickSize);
		this.takeLiquidityRate= Double.valueOf(takeLiquidityRate);
		this.provideLiquidityRate= Double.valueOf(provideLiquidityRate);
		this.feeCurrency= feeCurrency;
		
	}
	public Symbol(String id, String baseCurrency, String quoteCurrency, double quantityIncrement, double tickSize, double takeLiquidityRate, double provideLiquidityRate, String feeCurrency){
		this.id= id;
		this.baseCurrency= baseCurrency;
		this.quoteCurrency= quoteCurrency;
		this.quantityIncrement= quantityIncrement;
		this.tickSize= tickSize;
		this.takeLiquidityRate= takeLiquidityRate;
		this.provideLiquidityRate= provideLiquidityRate;
		this.feeCurrency= feeCurrency;
		
	}
	public Symbol() {
		this(null, null, null, 0, 0, 0, 0, null);
	}
	public void Info(){
		System.out.println("Trading pair: "+ this.baseCurrency+"/"+this.quoteCurrency+
							"\nMin buy: "+ this.quantityIncrement);
	}
}
class Currency{
	String id;
	String fullName;
	boolean crypto;
	boolean payinEnabled;
	boolean payinPaymentId;
	int payinConfirmations;
	boolean payoutEnabled;
	boolean payoutIsPaymentId;
	boolean transferEnabled;
	
	public Currency(String id, String fullName, boolean crypto, boolean payinEnabled, boolean payinPaymentId, int payinConfirmations, boolean payoutEnabled, boolean payoutIsPaymentId, boolean transferEnabled) {
		this.id= id;
		this.fullName= fullName;
		this.crypto= crypto;
		this.payinEnabled= payinEnabled;
		this.payinPaymentId= payinPaymentId;
		this.payinConfirmations= payinConfirmations;
		this.payoutEnabled= payoutEnabled;
		this.payoutIsPaymentId= payoutIsPaymentId;
		this.transferEnabled= transferEnabled;
	}
}
class Balance{
	String currency;
	double available;
	double reserved;
	
	public Balance(String currency, String available, String reserved) {
		this.currency= currency;
		this.available= Double.valueOf(available);
		this.reserved= Double.valueOf(reserved);
	}
	public void Info() {
		System.out.println("--"+this.currency+"\nAva:"+ this.available+"\nRes:"+this.reserved);
	}
}



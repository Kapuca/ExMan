package structures;

public class Currency{
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

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
	/*
	 * Constructors
	 */
	public Currency(String id, String fullName, boolean crypto, boolean payinEnabled, boolean payinPaymentId,
			int payinConfirmations, boolean payoutEnabled, boolean payoutIsPaymentId, boolean transferEnabled) {
		this.id = id;
		this.fullName = fullName;
		this.crypto = crypto;
		this.payinEnabled = payinEnabled;
		this.payinPaymentId = payinPaymentId;
		this.payinConfirmations = payinConfirmations;
		this.payoutEnabled = payoutEnabled;
		this.payoutIsPaymentId = payoutIsPaymentId;
		this.transferEnabled = transferEnabled;
	}
	/*
	 * Getters
	 */
	public String getId() {
		return id;
	}
	public String getFullName() {
		return fullName;
	}
	public boolean isCrypto() {
		return crypto;
	}
	public boolean isPayinEnabled() {
		return payinEnabled;
	}
	public boolean isPayinPaymentId() {
		return payinPaymentId;
	}
	public int getPayinConfirmations() {
		return payinConfirmations;
	}
	public boolean isPayoutEnabled() {
		return payoutEnabled;
	}
	public boolean isPayoutIsPaymentId() {
		return payoutIsPaymentId;
	}
	public boolean isTransferEnabled() {
		return transferEnabled;
	}
	/*
	 * Setters
	 */
	public void setId(String id) {
		this.id = id;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setCrypto(boolean crypto) {
		this.crypto = crypto;
	}
	public void setPayinEnabled(boolean payinEnabled) {
		this.payinEnabled = payinEnabled;
	}
	public void setPayinPaymentId(boolean payinPaymentId) {
		this.payinPaymentId = payinPaymentId;
	}
	public void setPayinConfirmations(int payinConfirmations) {
		this.payinConfirmations = payinConfirmations;
	}
	public void setPayoutEnabled(boolean payoutEnabled) {
		this.payoutEnabled = payoutEnabled;
	}
	public void setPayoutIsPaymentId(boolean payoutIsPaymentId) {
		this.payoutIsPaymentId = payoutIsPaymentId;
	}
	public void setTransferEnabled(boolean transferEnabled) {
		this.transferEnabled = transferEnabled;
	}
	/*
	 * The rest
	 */
	public void Info() {
		System.out.println(fullName + ": Payin " + (payinEnabled? "enabled" : "disabled") +
									  ". Payout "+ (payoutEnabled? "enabled" : "disabled") + ".");
	}
	
	
	
}

package ExAPI;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import structures.*;

public class HitBTC extends ApiAccount{

	public HitBTC(String username, String password) {
		super(username, password);
		this.ApiUrl= "https://api.hitbtc.com/api/2/";
	}
	public HitBTC() {
		this(null, null);
	}

	@Override
	public List<Pair> getPairs() throws ConnectionException {

		Type type = new TypeToken<ArrayList<Pair>>(){}.getType(); 
		@SuppressWarnings("unchecked")
		List<Pair> response= (List<Pair>) getAll("public/symbol", type);
		
		return response;
	}
	@Override
	public Pair getPair(String pairId) throws ConnectionException {
		
		Type type = new TypeToken<Pair>(){}.getType(); 
		Pair response= (Pair) getAll("public/symbol/"+pairId, type);
		
		return response;
	}
	@Override
	public List<Currency> getCurrency() throws ConnectionException {
		Type type = new TypeToken<ArrayList<Currency>>(){}.getType(); 
		@SuppressWarnings("unchecked")
		List<Currency> response= (List<Currency>) getAll("public/currency", type);
		
		return response;
	}
	@Override
	public Currency getCurrency(String currency) throws ConnectionException {
		Type type = new TypeToken<Currency>(){}.getType(); 
		Currency response= (Currency) getAll("public/currency/"+currency, type);
		
		return response;
	}
	@Override
	public List<Ticker> getTicker() throws ConnectionException {
		Type type = new TypeToken<ArrayList<Ticker>>(){}.getType(); 
		@SuppressWarnings("unchecked")
		List<Ticker> response= (List<Ticker>) getAll("public/ticker", type);
		
		return response;
	}
	@Override
	public Ticker getTicker(String pairId) throws ConnectionException {
		Type type = new TypeToken<Ticker>(){}.getType(); 
		Ticker response= (Ticker) getAll("public/ticker/"+pairId, type);
		
		return response;
	}
	@Override
	public List<PublicTrade> getPublicTrades(String pairId) throws ConnectionException {
		Type type = new TypeToken<ArrayList<PublicTrade>>(){}.getType(); 
		@SuppressWarnings("unchecked")
		List<PublicTrade> response= (List<PublicTrade>) getAll("public/publictrades", type);
		
		return response;
	}
	@Override
	public Orderbook getOrderbook(String pairId) throws ConnectionException {
		Type type = new TypeToken<Orderbook>(){}.getType(); 
		Orderbook response= (Orderbook) getAll("public/orderbook/"+pairId, type);
		
		return response;
	}
	@Override
	public List<Candle> getCandle(String pairId) throws ConnectionException {
		Type type = new TypeToken<ArrayList<Candle>>(){}.getType(); 
		@SuppressWarnings("unchecked")
		List<Candle> response= (List<Candle>) getAll("public/candle", type);
		
		return response;
	}
	/*
	 * Account methods
	 * (non-Javadoc)
	 * @see ExAPI.ApiAccount#getBalance()
	 */
	@Override
	public List<Balance> getBalance() throws ConnectionException {
		
		List<Balance> abalance= getAccountBalance();
		List<Balance> tbalance= getTradingBalance();
		boolean skip=false;
		for (Balance ab : abalance) {
			for (Balance tb : tbalance) {
				if (tb.currency.equals(ab.currency)) {
					tb.available+= ab.available;
					tb.reserved+= ab.reserved;
					skip= true;
					break;
				}
			}
			if (!skip) tbalance.add(ab);
			skip= false;
		}
		return tbalance;
	}
	@Override
	public Balance getBalance(String currency) throws ConnectionException {
				
		throw new ConnectionException("Not implemented");
	}
	public List<Balance> getTradingBalance() throws ConnectionException {
		/*
		 * Return trading ballance if account has proper auth
		 */
		Type type = new TypeToken<ArrayList<Balance>>(){}.getType(); 
		@SuppressWarnings("unchecked")
		List<Balance> response= (List<Balance>) getAll("trading/balance", true, type);
		response= cleanBalanceData(response);
		return response;
	}
	public Balance getTradingBalance(String currency) throws ConnectionException {
		Type type = new TypeToken<Balance>(){}.getType(); 
		Balance response= (Balance) getAll("trading/balance/"+ currency, true, type);
		return response;
	}
	public List<Balance> getAccountBalance() throws ConnectionException {
		/*
		 * Return account ballance if account has proper auth
		 */
		Type type = new TypeToken<ArrayList<Balance>>(){}.getType(); 
		@SuppressWarnings("unchecked")
		List<Balance> response= (List<Balance>) getAll("account/balance", true, type);
		response= cleanBalanceData(response);
		return response;
		
	}
	public Balance getAccountBalance(String currency) throws ConnectionException {
		Type type = new TypeToken<Balance>(){}.getType(); 
		Balance response= (Balance) getAll("account/balance/"+ currency, true, type);
		return response;
	}
	private List<Balance> cleanBalanceData(List<Balance> response) {
		/*
		 * Removes 0 balance enteries.
		 */
		int i= 0;
		while (i<response.size()) {
			if (response.get(i).available==0 && response.get(i).reserved==0) {
				response.remove(i);
			}else {
				i++;
			}
		}
		return response;
	}


	

	
	
}

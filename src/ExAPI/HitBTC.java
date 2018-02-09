package ExAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
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
		HttpsURLConnection conn= makeConn("public/symbol", false);
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));	
			Gson gson= new Gson();
			Type type = new TypeToken<ArrayList<Pair>>(){}.getType(); 
			List<Pair> response= gson.fromJson(br.readLine(), type);
			
			conn.disconnect();
			return response;
			
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Pair getPair(String pairId) throws ConnectionException {
		// TODO Auto-generated method stub
		throw new ConnectionException("Not implemented");
	}
	@Override
	public Currency[] getCurrency() throws ConnectionException {
		// TODO Auto-generated method stub
		throw new ConnectionException("Not implemented");
	}
	@Override
	public Currency getCurrency(String curren) throws ConnectionException {
		// TODO Auto-generated method stub
		throw new ConnectionException("Not implemented");
	}
	@Override
	public Ticker[] getTicker() throws ConnectionException {
		// TODO Auto-generated method stub
		throw new ConnectionException("Not implemented");
	}
	@Override
	public Ticker getTicker(String pairId) throws ConnectionException {
		// TODO Auto-generated method stub
		throw new ConnectionException("Not implemented");
	}
	@Override
	public PublicTrade[] getPublicTrades(String pairId) throws ConnectionException {
		// TODO Auto-generated method stub
		throw new ConnectionException("Not implemented");
	}
	@Override
	public Orderbook getOrderbook(String pairId) throws ConnectionException {
		// TODO Auto-generated method stub
		throw new ConnectionException("Not implemented");
	}
	@Override
	public Candle[] getCandle(String pairId) throws ConnectionException {
		// TODO Auto-generated method stub
		throw new ConnectionException("Not implemented");
	}
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
		
		HttpsURLConnection conn= makeConn("trading/balance", true);
	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));	
			Gson gson= new Gson();
			Type type = new TypeToken<ArrayList<Balance>>(){}.getType(); 
			List<Balance> response= gson.fromJson(br.readLine(), type);
			
			conn.disconnect();
			response= cleanBalanceData(response);
			return response;
			
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return null;
	}
	public List<Balance> getAccountBalance() throws ConnectionException {
		
		HttpsURLConnection conn= makeConn("account/balance", true);
	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			Gson gson= new Gson();
			Type type = new TypeToken<ArrayList<Balance>>(){}.getType(); 
			List<Balance> response= gson.fromJson(br.readLine(), type);
			
			conn.disconnect();
			response= cleanBalanceData(response);
			return response;
			
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return null;
		
	}
	private List<Balance> cleanBalanceData(List<Balance> response) {
		
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

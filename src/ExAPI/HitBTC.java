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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Pair getPair(String pairId) throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Currency[] getCurrency() throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Currency getCurrency(String curren) throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Ticker[] getTicker() throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Ticker getTicker(String pairId) throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PublicTrade[] getPublicTrades(String pairId) throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Orderbook getOrderbook(String pairId) throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Candle[] getCandle(String pairId) throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Balance> getBalance() throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Balance getBalance(String currency) throws ConnectionException {
		List<Balance> Tarr, Aarr;

		Aarr= getAccountBalance();
		Tarr= getTradingBalance();
		
		System.out.println("T:"+Tarr.size()+"\nA:"+Aarr.size());
		for (Balance balance : Aarr) {
			boolean skip= false;
			for (Balance Tbalance : Tarr) {
				if (balance.currency.equals(Tbalance.currency)) {
					skip= true;
					break;
				}
			}
			if (!skip) balance.Info();
		}
		return null;
	}
	public List<Balance> getTradingBalance() throws ConnectionException {
		
		HttpsURLConnection conn= makeConn("trading/balance");
	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));	
			Gson gson= new Gson();
			Type type = new TypeToken<ArrayList<Balance>>(){}.getType(); 
			List<Balance> response= gson.fromJson(br.readLine(), type);
			
			conn.disconnect();
			return response;
			
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return null;
	}
	public List<Balance> getAccountBalance() throws ConnectionException {
		
		HttpsURLConnection conn= makeConn("account/balance");
	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			Gson gson= new Gson();
			Type type = new TypeToken<ArrayList<Balance>>(){}.getType(); 
			List<Balance> response= gson.fromJson(br.readLine(), type);
			
			conn.disconnect();
			
			return response;
			
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return null;
		
	}
	

	
	
}

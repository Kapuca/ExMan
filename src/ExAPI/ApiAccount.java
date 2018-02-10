package ExAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

import structures.*;

public abstract class ApiAccount {
	protected String username;
	private String password;
	public String ApiUrl;
	
	public ApiAccount(String username, String password) {
		this.username= username;
		this.password= password;
	}
	public ApiAccount() {
		this(null, null);
	}

	//Setters and getters
	public void setUsername(String username) {
		this.username= username;
	}
	public void	setPassword(String password) {
		this.password= password;
		
	}
	public void setApiUrl(String ApiUrl) {
		this.ApiUrl= ApiUrl;
	}
	
	protected String getHTTPAuth() throws ConnectionException {
		if (this.username==null) {
			throw new ConnectionException("Set API Keys");
		}
		String userpass = this.username + ":" + this.password;
		return new String(Base64.getEncoder().encode(userpass.getBytes()));
	}
	protected HttpsURLConnection makeConn(String urlExtension, boolean authorization) throws ConnectionException{
		try {
			URL url= new URL(ApiUrl+urlExtension);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (authorization) {
				String basicAuth = "Basic " + getHTTPAuth();
				conn.setRequestProperty ("Authorization", basicAuth);
			}
			

			if (conn.getResponseCode()==401) throw new ConnectionException("API keys not valid.");
			if (conn.getResponseCode() != 200) {
				
				throw new ConnectionException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			return conn;

		} catch (MalformedURLException e) {
			System.err.println(e);
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new ConnectionException("Unknown IOException, refer to stack trace.");
		}
		
		return null;
	}
	
	protected Object getAll(HttpsURLConnection conn, Type type) throws ConnectionException {
		BufferedReader br = null;
		try { br = new BufferedReader(new InputStreamReader(conn.getInputStream()));}
		catch (IOException e1) {
			e1.printStackTrace();
			throw new ConnectionException("Bad connection?");
		}	
		Gson gson= new Gson();
		try {
			Object response= gson.fromJson(br.readLine(), type);
			return response;	
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return null;
	}
	protected Object getAll(String urlExtension, Type type) throws ConnectionException{
		return getAll(urlExtension, false, type);
	}
	protected Object getAll(String urlExtension, boolean auth, Type type) throws ConnectionException {
		HttpsURLConnection conn= makeConn(urlExtension, auth);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));	
			Gson gson= new Gson();
			Object response= gson.fromJson(br.readLine(), type);
			conn.disconnect();
			return response;	
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * Public methods
	 */
	public abstract List<Pair> getPairs() throws ConnectionException;
	public abstract Pair getPair(String pairId) throws ConnectionException;
	
	public abstract List<Currency> getCurrency() throws ConnectionException;
	public abstract Currency getCurrency(String curren) throws ConnectionException;
	
	public abstract List<Ticker> getTicker() throws ConnectionException;
	public abstract Ticker getTicker(String pairId) throws ConnectionException;
	
	public abstract List<PublicTrade> getPublicTrades(String pairId) throws ConnectionException;
	public abstract Orderbook getOrderbook(String pairId) throws ConnectionException;
	public abstract List<Candle> getCandle(String pairId) throws ConnectionException;
	
	/*
	 * Account methods
	 */
	public abstract List<Balance> getBalance() throws ConnectionException;	
	public abstract Balance getBalance(String currency) throws ConnectionException;
	
	
}


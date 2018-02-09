package ExAPI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import structures.*;

public abstract class ApiAccount {
	protected String username;
	private String password;
	public String ApiUrl;
	public String name;
	
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
	
	/*
	 * Public methods
	 */
	public abstract List<Pair> getPairs() throws ConnectionException;
	public abstract Pair getPair(String pairId) throws ConnectionException;
	
	public abstract Currency[] getCurrency() throws ConnectionException;
	public abstract Currency getCurrency(String curren) throws ConnectionException;
	
	public abstract Ticker[] getTicker() throws ConnectionException;
	public abstract Ticker getTicker(String pairId) throws ConnectionException;
	
	public abstract PublicTrade[] getPublicTrades(String pairId) throws ConnectionException;
	public abstract Orderbook getOrderbook(String pairId) throws ConnectionException;
	public abstract Candle[] getCandle(String pairId) throws ConnectionException;
	
	/*
	 * Account methods
	 */
	public abstract List<Balance> getBalance() throws ConnectionException;	
	public abstract Balance getBalance(String currency) throws ConnectionException;
	
	
}


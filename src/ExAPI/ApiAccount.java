package ExAPI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

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
	public void setUsername(String username) {
		this.username= username;
	}
	
	public void	setPassword(String password) {
		this.password= password;
		
	}
	protected String getHTTPAuth() {
		if (this.username==null) {
//			throw new ;
		}
		String userpass = this.username + ":" + this.password;
		return new String(Base64.getEncoder().encode(userpass.getBytes()));
	}
	protected HttpsURLConnection makeConn(String urlExtension) throws ConnectionException{
		try {
			URL url= new URL(ApiUrl+urlExtension);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			String basicAuth = "Basic " + getHTTPAuth();
			conn.setRequestProperty ("Authorization", basicAuth);

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
	
	public abstract Balance[] getBalance() throws ConnectionException;
}


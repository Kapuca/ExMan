package ExAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

import structures.*;

public class HitBTC extends ApiAccount{

	public HitBTC(String username, String password) {
		super(username, password);
		this.ApiUrl= "https://api.hitbtc.com/api/2/";
	}
	
	public HitBTC() {
		this(null, null);
	}

	public Balance[] getTradingBalance() throws ConnectionException {
		
		HttpsURLConnection conn= makeConn("trading/balance");

		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream())
			);
			//System.out.println("Output from Server ....");

			String output = br.readLine();
			Gson gson= new Gson();
			Balance[] response= gson.fromJson(output, Balance[].class);
			
			conn.disconnect();
			
			return response;
			
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return null;
	}

	public Balance[] getAccountBalance() throws ConnectionException {
		
		HttpsURLConnection conn= makeConn("account/balance");

		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream())
			);
			//System.out.println("Output from Server ....");

			String output = br.readLine();
			Gson gson= new Gson();
			Balance[] response= gson.fromJson(output, Balance[].class);
			
			conn.disconnect();
			
			return response;
			
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return null;
		
	}
	@Override
	public Balance[] getBalance() throws ConnectionException {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
}

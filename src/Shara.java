import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.Gson;

public class Shara {
	public static void main(String[] args) {

		  try {

			  
			URL url = new URL("https://api.hitbtc.com/api/2/public/symbol");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output = br.readLine();
			System.out.println("Output from Server ....");
			Gson gson= new Gson();
			Symbol[] symbols= gson.fromJson(output, Symbol[].class);
			for(int i=0; i< symbols.length; i++){
				symbols[i].Info();
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		  

		}


}

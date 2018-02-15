import java.util.List;

import ExAPI.ConnectionException;
import ExAPI.HitBTC;
import gui.Gui;
import structures.Balance;
import structures.Candle;
import structures.Currency;
import structures.Orderbook;
import structures.Pair;
import structures.PublicTrade;
import structures.Ticker;;

public class Shara {
	public static void main(String[] args) {


//		try {
//			List<Candle> can;
//			List<PublicTrade> pTrades;
//			Orderbook ob;
//			List<Pair> pairs;
//			List<Balance> balances;
//			List<Currency> currencies;
//			List<Ticker> tickers;
//			tickers= account.getTicker();
//			for (Ticker ticker : tickers) {
//				ticker.Info();
//			}
//			currencies= account.getCurrency();
//			for (Currency currency : currencies) {
//				currency.Info();
//			}
//			balances= account.getBalance();
//			for (Balance balance : balances) {
//				balance.Info();
//			}
//			pairs= account.getPairs();
//			for (Pair pair : pairs) {
//				pair.Info();
//			}
//			ob= account.getOrderbook("xmrbtc", 4);
//			ob.Info();
//			pTrades= account.getPublicTrades("ethbtc");
//			for (PublicTrade publicTrade : pTrades) {
//				publicTrade.Info();
//			}
//			can= account.getCandle("btcusd", 5, "H4");
//			
//			for(Candle c: can){
//				c.Info();
//			}
//		} catch (ConnectionException e) {
//			System.err.println(e.getMessage());
//			e.printStackTrace();
//		}
//Gui testing
		
		Gui gui = new Gui();
		gui.main(args);
		  

	}


}

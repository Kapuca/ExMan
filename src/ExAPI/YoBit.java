package ExAPI;

import java.util.List;

import structures.Balance;
import structures.Candle;
import structures.Currency;
import structures.Orderbook;
import structures.Pair;
import structures.PublicTrade;
import structures.Ticker;

public class YoBit extends ApiAccount{

	public YoBit(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return null;
	}



}

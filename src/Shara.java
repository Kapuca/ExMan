import java.util.List;

import ExAPI.ApiAccount;
import ExAPI.ConnectionException;
import ExAPI.HitBTC;
import gui.Gui;
import structures.Pair;;

public class Shara {
	public static void main(String[] args) {


//		HitBTC account= new HitBTC("username", "password");
//		try {
//			List<Balance> Tarr, Aarr;
//
//			Aarr= account.getAccountBalance();
//			Tarr= account.getTradingBalance();
//			
//			for(int i=0; i< Aarr.size(); i++){
//				Aarr.get(i).Info();
//			}
//			for(int i=0; i< Tarr.size(); i++){
//				Tarr.get(i).Info();
//			}
//			System.out.println("T:"+Tarr.size()+"\nA:"+Aarr.size());
//			for (Balance balance : Aarr) {
//				boolean skip= false;
//				for (Balance Tbalance : Tarr) {
//					if (balance.currency.equals(Tbalance.currency)) {
//						skip= true;
//						break;
//					}
//				}
//				if (!skip) balance.Info();
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

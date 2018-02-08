import structures.*;

import ExAPI.*;

public class Shara {
	public static void main(String[] args) {


		HitBTC account= new HitBTC("userpass here", "secret here");
		Balance[] arr;
		try {
			arr = account.getAccountBalance();
			
			for(int i=0; i< arr.length; i++){
				if (arr[i].available!=0 || arr[i].reserved!=0) {
					arr[i].Info();					
				}
			}
		} catch (ConnectionException e) {
			System.err.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		  

	}


}

package gui;

import java.util.List;

import ExAPI.ConnectionException;
import ExAPI.HitBTC;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import structures.Balance;
import structures.Pair;

public class Controller {
	@FXML ListView<Label> PairList;
	@FXML ListView<Label> BalanceList;
	@FXML Tab PortfolioTab;
	
	HitBTC acc;
	
	@FXML
	public void initialize() {
		acc= new HitBTC("username","password");
		try {
			List<Pair> pairs= acc.getPairs();
			for (int i=0; i<pairs.size(); i++) {
				PairList.getItems().add(new Label(pairs.get(i).getBaseCurrency()+"/"+pairs.get(i).getQuoteCurrency()));
			}
		} catch (ConnectionException e) {
			PairList.setEditable(false);
			e.printStackTrace();
		}
		try {
			List<Balance> fullBalance= acc.getBalance();
			for (int i=0; i<fullBalance.size(); i++) {
				BalanceList.getItems().add(new Label(fullBalance.get(i).currency+": "+fullBalance.get(i).getTotal()));
			}
		} catch (ConnectionException e) {
			PortfolioTab.setDisable(true);
			System.out.println("Portfolio set disabled");
			
			e.printStackTrace();
		}
	}
	
	public void addOnList() {
		
	}

}

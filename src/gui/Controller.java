package gui;

import java.util.List;

import ExAPI.ConnectionException;
import ExAPI.HitBTC;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import structures.Balance;
import structures.Pair;
import structures.Ticker;

public class Controller {
	@FXML ListView<Label> PairList;
	@FXML ListView<Label> BalanceList;
	@FXML Tab PortfolioTab;
	@FXML Label bottomLabel;
	
	HitBTC acc;
	
	@FXML
	public void initialize() {
		acc= new HitBTC("user","pass");
		try {
			List<Pair> allpair= acc.getPairs();
			for (Pair pairs : allpair) {
				Label tmp= new Label(pairs.getBaseCurrency()+"/"+pairs.getQuoteCurrency());
				tmp.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						Ticker ticker= null;
						try {
							ticker= acc.getTicker(tmp.getText().replaceAll("/", ""));
						} catch (ConnectionException e) {
							bottomLabel.setText("Could not load " + tmp.getText());
//							e.printStackTrace();
						}
						bottomLabel.setText(tmp.getText()+" 24h change: "
									+ ticker.getChange() + "% Price: "
									+ ticker.getLast() + pairs.getQuoteCurrency());
					}
				});
				PairList.getItems().add(tmp);
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

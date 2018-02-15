package gui.controller;

import java.util.List;

import ExAPI.ConnectionException;
import ExAPI.HitBTC;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import structures.Balance;
import structures.Pair;
import structures.Ticker;

public class MainCon {
	
	@FXML AnchorPane main;
	@FXML Chart chartController;
	@FXML ListView<Label> PairList;
	@FXML ListView<Label> BalanceList;
	@FXML Tab PortfolioTab;
	@FXML GuiFrame master;
	
	
	HitBTC acc;
	
	@FXML
	public void initialize() {
		System.out.println(chartController);
		acc= new HitBTC("498cf9df17aa3b42372b07354179900b", "1e1f9bb3fcc5d50a024bf2e80e874acc");
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
							master.BottomLabel.setText("Could not load " + tmp.getText());
//							e.printStackTrace();
						}
						master.BottomLabel.setText(tmp.getText()+" 24h change: "
									+ ticker.getChange(true) + "% Price: "
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
			System.out.println("Portfolio set disabled. " + e.getMessage());
		}
	}
	
	public void addOnList() {
		
	}
	
	public void inject(GuiFrame guiFrame) {
		this.master= guiFrame;
		chartController.inject(guiFrame);
		System.out.println("Inj in main.");
	}
	

}

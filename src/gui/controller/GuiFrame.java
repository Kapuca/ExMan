package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;

public class GuiFrame {
	
	@FXML VBox guiFrame;
	@FXML Label BottomLabel;
	@FXML MenuBar UpperBar;
	@FXML MainCon mainController;

	@FXML
	public void initialize(){
		System.out.println(this);
		System.out.println(mainController);
		mainController.inject(this);
		
	}


	
	
	
}

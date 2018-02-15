package gui.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Chart {
	
	@FXML AnchorPane chart;
	@FXML GuiFrame master;

	public void inject(GuiFrame guiFrame) {
		this.master= guiFrame;
	}
}

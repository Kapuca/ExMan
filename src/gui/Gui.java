package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gui extends Application{
	
	public void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Loading fxml...");
		Parent root= FXMLLoader.load(getClass().getResource("fxml/GuiFrame.fxml"));
		primaryStage.setTitle("ExMan");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

}

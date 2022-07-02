package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static Stage stg;
	@Override
	public void start(Stage Stage) throws Exception {
		
            stg = Stage;		
			Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
			Scene scene = new Scene(root);
			Stage.setScene(scene);
			Stage.show();
		
		
		}
		
		
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
		}
	/*public void gotomainwindow(ActionEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();*/
	
	public static void main(String[] args) throws IOException {
		
		//GUIMethods gui = new GUIMethods();
		//gui.SignUp();
		launch(args);
		
		
	}
	
}

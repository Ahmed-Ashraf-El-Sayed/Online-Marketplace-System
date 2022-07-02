package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainWindowController {
	
	
	
	public void logout(ActionEvent e)throws IOException{
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	

 }


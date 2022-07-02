package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	
	
	@FXML
	private Label wrongLogin;
	
	@FXML
	private ChoiceBox<String> myChoiceBox;
	@FXML
	private Button button;
	@FXML
	private TextField username;
	@FXML 
	private PasswordField password;
	
	
	private String[] users = {"Admin","User"};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		

	}
	
		 
	
	public void userLogin (ActionEvent event)throws IOException{
		checklogin();
	}
	private void checklogin ()throws IOException {
		Main m = new Main();
		if(username.getText().toString().equals("darsh") && password.getText().toString().equals("123")) {
			wrongLogin.setText("Success!");
			m.changeScene("MainWindow.fxml");
		}
		else if (username.getText().isEmpty()&& password.getText().isEmpty()) {
			wrongLogin.setText("Enter Data");
		}
		else {
			wrongLogin.setText("Wrong Username Or Password");
		}
	}
	 
	 
}

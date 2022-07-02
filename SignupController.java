package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController {
	@FXML
	private TextField username;
	@FXML 
	private PasswordField password;
 	
      public void createAccount () {
    	  
    	  String un = username.getText().toString();
    	  String pw = password.getText().toString();
          Account account = new Account(un,pw);
          Client client = new Client(account);
          server.dataBase.SignUp(client);
    	  
      }
	 public void logout(ActionEvent e)throws IOException{
			Main m = new Main();
			m.changeScene("Login.fxml");
		}
}

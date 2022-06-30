package application;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class LoginController implements Initializable{
	
	@FXML
	private Label myLabel;
	
	@FXML
	private ChoiceBox<String> myChoiceBox;
	
	private String[] users = {"Admin","User"};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		myChoiceBox.getItems().addAll(users);

	}

}

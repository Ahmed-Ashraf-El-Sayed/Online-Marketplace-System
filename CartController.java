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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CartController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switch_To_proceed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("OrderDone.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(URL arg0, ResourceBundle arg1) {

    }



        public  void deleteItems(ActionEvent e){

    }
    public void calc_Price(ActionEvent e){

    }
}

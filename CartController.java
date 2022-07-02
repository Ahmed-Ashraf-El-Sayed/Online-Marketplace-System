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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class CartController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private ListView<String> list1;
    @FXML
    private ListView<String> list2;
    @FXML
    private ListView<String> list3;
    @FXML
    private  Label LABEL1;
    String[] items={"book","game","CD"};
    double [] prices={20,30,50.2};
    int quantaties[]={1,2,5};
    String currentItem;

    public void initialize(URL arg0, ResourceBundle arg1) {
        list1.getItems().addAll(items);
//        list1.getSelectionModel().
////        list2.getItems().addAll(String.valueOf(prices));
////        list3.getItems().addAll(String.valueOf(quantaties));
    }

    public void switch_To_proceed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("OrderDone.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public  void deleteItems(ActionEvent e){
        list1.getItems().clear();

    }
    public void calc_Price(ActionEvent e){
        double total =0;
        for(int i=0;i<items.length;i++){
            total =total+quantaties[i]*prices[i];
        }
        LABEL1.setText("Total Price= "+total);
    }
}

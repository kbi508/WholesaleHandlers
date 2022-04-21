package application;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Page3Controller {

    @FXML
    private AnchorPane pane3;

    @FXML
    private TextArea textarea1;

    @FXML
    private TextArea textarea2;

    @FXML
    private TextArea textarea3;
    
    @FXML
    private TextArea textarea4;
    
    

    @FXML
    void handle1(ActionEvent event) throws IOException {
    	pane3 = FXMLLoader.load(getClass().getResource("page2.fxml"));
    	Scene scene = new Scene(pane3, 750, 600);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();

    }
    @FXML
    void handle2(ActionEvent event) {

    }
    

}

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

public class Page4Controller {

    @FXML
    private AnchorPane finalpane;
    @FXML
    private TextArea textArea;

    @FXML
    void handle1(ActionEvent event) throws IOException {
    	finalpane = FXMLLoader.load(getClass().getResource("Main.fxml"));
    	Scene scene = new Scene(finalpane, 600, 600);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();


    }

}

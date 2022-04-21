package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Page2Controller {
	@FXML
	private ListView<?> ListView1;
    
    

    @FXML
    private AnchorPane pane4;

    @FXML
    void handle1(ActionEvent event) throws IOException {
    	pane4 = FXMLLoader.load(getClass().getResource("Main.fxml"));
    	Scene scene = new Scene(pane4, 600, 600);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();


    }
    @FXML
    void handle2(ActionEvent event) throws IOException {
    	pane4 = FXMLLoader.load(getClass().getResource("page3.fxml"));
    	Scene scene = new Scene(pane4, 600, 500);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
	
		

    }
    @FXML
    void handle3(ActionEvent event) throws IOException {
    	pane4 = FXMLLoader.load(getClass().getResource("page4.fxml"));
    	Scene scene = new Scene(pane4, 600, 500);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();

    }

}
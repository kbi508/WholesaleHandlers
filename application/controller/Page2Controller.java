package application.controller;

import java.io.IOException;

import javax.swing.event.ChangeListener;

import application.Model.Inventory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Page2Controller {
	@FXML
	private ListView<String> ListView1 ;
    
    

    @FXML
    private AnchorPane pane4;
    
    private Inventory i = Inventory.getInstance();
    
    @FXML
	void initialize() {
		ObservableList<String> data =  FXCollections.observableArrayList(Inventory.invStr(i));
		ListView1.getItems().addAll(data);
	}
    
    
    
    

    @FXML
    void handle1(ActionEvent event) throws IOException {
    	pane4 = FXMLLoader.load(getClass().getResource("/application/view/Main.fxml"));
    	Scene scene = new Scene(pane4, 600, 600);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();


    }
    @FXML
    void handle2(ActionEvent event) throws IOException {
    	Inventory i = Inventory.getInstance();
    	i.choice = ListView1.getSelectionModel().getSelectedIndex();
    	pane4 = FXMLLoader.load(getClass().getResource("/application/view/page3.fxml"));
    	Scene scene = new Scene(pane4, 600, 500);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
	
		

    }
    @FXML
    void handle3(ActionEvent event) throws IOException {
    	pane4 = FXMLLoader.load(getClass().getResource("/application/view/page4.fxml"));
    	Scene scene = new Scene(pane4, 600, 500);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();

    }

}
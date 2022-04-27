package application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.swing.event.ChangeListener;

import application.Model.Inventory;
import application.Model.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InventoryController {
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
    	if(ListView1.getSelectionModel().getSelectedIndex() ==-1) {
    		Alert bad = new Alert(AlertType.ERROR);
    		bad.setHeaderText("No item was selected");
    		bad.setContentText("Please Select an item to check inventory on!");
    		bad.showAndWait();
    		return;
    	}
    	Inventory i = Inventory.getInstance();
    	i.choice = ListView1.getSelectionModel().getSelectedIndex();
    	pane4 = FXMLLoader.load(getClass().getResource("/application/view/quantity.fxml"));
    	Scene scene = new Scene(pane4);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.sizeToScene();
    	window.setScene(scene);
    	window.show();
    	}
    
    
    @FXML
    void handle3(ActionEvent event) throws IOException {
    	Inventory i = Inventory.getInstance();
    	ArrayList<String> untouched = new ArrayList<String>();
    	for(Item item: i.getList()) {
    		if(!item.getChecked()) {
    			untouched.add(item.getName());
    		} 
    	}
    	if(untouched.isEmpty()==false) {
    		String uSure = "You have not checked inventory for the following items: ";
    		for(String s: untouched) {
    			uSure += "\n" + s;
    		}
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Inventroy not fully reported");
    		alert.setHeaderText(uSure);
    		alert.setContentText("Do you want to continue without these items?");
    		Optional<ButtonType> result = alert.showAndWait();
    		if(result.get() != ButtonType.OK) {
    			alert.close();
    			return;
    		}else {
    			alert.close();
    		}
    	}
    	
    	pane4 = FXMLLoader.load(getClass().getResource("/application/view/receipt.fxml"));
    	Scene scene = new Scene(pane4, 600, 600);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();

    }

}
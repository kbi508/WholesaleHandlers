package application.controller;

import java.io.IOException;

import application.Model.Inventory;
import application.Model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Page3Controller {

    @FXML
    private AnchorPane pane3;

    @FXML
    private Label curName;
    
    @FXML
    private Label curMax;
    
    @FXML
    private Label curPrice;
    
    @FXML
    private TextField userAmmount;
    
    @FXML
    private Label query;
    
    
    private Item curItem;
    
    
    /*public void userChoice(int c) {
    	choice = c;
    	System.out.println("User Choice");
    }*/
    
    @FXML
	void initialize() {
		Inventory inv = Inventory.getInstance();
    	if(inv.choice >= 0) {
    		curItem = inv.getList().get(inv.choice);
    		curName.setText(curItem.getName());
    		curMax.setText(String.format("Max Capacity: %d", curItem.getMaxAmmount()));
    		curPrice.setText(String.format("Price: %.2f", curItem.getSupPrice()));
    		query.setText("How many " + curItem.getName() + "s do you have?");
    	}
    }
    
    
    
    

    @FXML
    void handle1(ActionEvent event) throws IOException {
    	pane3 = FXMLLoader.load(getClass().getResource("/application/view/page2.fxml"));
    	Scene scene = new Scene(pane3, 750, 600);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();

    }
    @FXML
    void handle2(ActionEvent event) {
    	try {
    		int has = Integer.parseInt(userAmmount.getText());
    		if( has >= 0) {
    			curItem.setHas(has);
    			query.setText(String.format("You have %d %ss",curItem.getHas(), curItem.getName()));
    			query.setAlignment(Pos.BASELINE_RIGHT);
    		}
    		
    	} catch (NumberFormatException e) {
    		Alert alert = new Alert(AlertType.INFORMATION, "Content here", ButtonType.OK);
    		alert.show();
    	}

    }
    

}

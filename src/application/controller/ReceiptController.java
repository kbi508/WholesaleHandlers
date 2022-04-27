package application.controller;

import java.io.IOException;

import application.Model.Inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ReceiptController {

    @FXML
    private AnchorPane finalpane;
    @FXML
    private TextFlow finalFlo;
    
    @FXML
    void initialize() {
    	Inventory i = Inventory.getInstance();
    	Text fin = new Text(i.getNeeds());
    	fin.setFill(Color.BLACK);
    	fin.setFont(new Font(14));
    	finalFlo.getChildren().add(fin);
    }

    @FXML
    void handle1(ActionEvent event) throws IOException {
    	finalpane = FXMLLoader.load(getClass().getResource("/application/view/Main.fxml"));
    	Scene scene = new Scene(finalpane, 600, 600);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();


    }

}
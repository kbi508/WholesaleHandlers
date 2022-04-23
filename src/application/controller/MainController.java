package application.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.filechooser.FileSystemView;
import application.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
public class MainController {
	@FXML
	private AnchorPane mainPane;
	
	@FXML
	private Label fileName;
	
	public File f;
	
	ArrayList<Item> inv = new ArrayList<Item>();
	
	
	void initialize() {
		fileName.setAlignment(Pos.BASELINE_CENTER);
		fileName.setTextAlignment(TextAlignment.CENTER);
	}

    @FXML
    public void handle1(ActionEvent event) throws IOException{
    	FileChooser fc = new FileChooser();
    	File dir = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + (System.getProperty("os.name").toLowerCase().contains("mac") ? "/Documents" : "") + "/InventoryData");
    	if(!dir.exists())dir.mkdir();
    	fc.setInitialDirectory(dir);
    	
    	f = fc.showOpenDialog(null);
    	
    	
    	if(f != null) {
    		fileName.setText(f.getName());
    	} else {
    		Alert bad = new Alert(AlertType.ERROR);
    		bad.setHeaderText("No File was selected for reading");
    		bad.setContentText("Please select a correctly formated Inventory file");
    		bad.showAndWait();
    	}
    	
    	
    }
    
    @FXML
    public void handle2(ActionEvent event) throws IOException{
    	if(f!=null) {
    		Inventory i = Inventory.getInstance();
    		Inventory.bigRead(f,i);
	    	mainPane = FXMLLoader.load(getClass().getResource("/application/view/page2.fxml"));
	    	Scene scene = new Scene(mainPane, 750, 600);
	    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
    	}else {
    		Alert bad = new Alert(AlertType.ERROR);
    		bad.setHeaderText("No File was selected for reading");
    		bad.setContentText("Please select a correctly formated Inventory file");
    		bad.showAndWait();
    	}

    }

   
    

}
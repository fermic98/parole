package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;


public class FXMLController {
	
	Parole elenco = new Parole() ;
	String stringa1 = "";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextArea txtTime;

    @FXML
    private Button btnCancella;
    @FXML
    private Button btnReset;
    
    @FXML
    void cancellaSelezionata(ActionEvent event) {
    	
    	long startingTime = System.nanoTime();	
    	elenco.getElenco().remove(stringa1);
        String stringa="";
    	for(String s : elenco.getElenco()) {
    		stringa+=s+"\n";
    	}
    	txtResult.setText(stringa);
           	
        
     	long estimatedTime = startingTime - System.nanoTime();
     	String time = Integer.toString((int) estimatedTime);
     	this.txtTime.appendText(time);
    }
    @FXML
    void doInsert(ActionEvent event) {
    	long startingTime = System.nanoTime();	
    	elenco.addParola(this.txtParola.getText());
    	String stringa="";
    	for(String s : elenco.getElenco()) {
    		stringa+=s+"\n";
    	}
    	txtResult.setText(stringa);
    	this.txtParola.clear();
    	
        
        
     	long estimatedTime = startingTime - System.nanoTime();
     	String time = Integer.toString((int) estimatedTime);
     	this.txtTime.appendText(time);
    	}

    	@FXML
    	void doReset(ActionEvent event) {
        long startingTime = System.nanoTime();	
    	elenco.reset();
    	txtResult.clear();
     	long estimatedTime = startingTime - System.nanoTime();
     	String time = Integer.toString((int) estimatedTime);
     	this.txtTime.appendText(time);
    	}

        @FXML
        void parolaClickata(MouseDragEvent event) {
           long startingTime = System.nanoTime();	
            stringa1= this.txtResult.getSelectedText();
           
           long estimatedTime = startingTime - System.nanoTime();
        	String time = Integer.toString((int) estimatedTime);
        	this.txtTime.appendText(time);
        }
        @FXML
        void initialize() {
            assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
            assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
            assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
            assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
            assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
            assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        }
}

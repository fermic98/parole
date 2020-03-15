package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;


import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;



public class FXMLController {
	
	Parole elenco = new Parole() ;
	String stringa1 = null;
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
    	stringa1= this.txtResult.getSelectedText();
    	for(String s : elenco.getElenco()) {
    		if(s.compareTo(stringa1)==0) {
    			elenco.getElenco().remove(s);
    		}
    	}
    	
        String stringa="";
        LinkedList<String> ordinata= new LinkedList<String>(elenco.getElenco());
    	for(String s : ordinata) {
    		stringa+=s+"\n";
    	}
    	txtResult.setText(stringa);
           	
        
    	long estimatedTime = System.nanoTime()-startingTime ;
     	String time = Long.toString(estimatedTime);
     	this.txtTime.appendText(time+"\n");
    }
    @FXML
    void doInsert(ActionEvent event) {
    	long startingTime = System.nanoTime();	
    	elenco.addParola(this.txtParola.getText());
    	String stringa="";
    	LinkedList<String> ordinata= new LinkedList<String>(elenco.getElenco());
    	for(String s : ordinata) {
    		stringa+=s+"\n";
    	}
    	txtResult.setText(stringa);
    	this.txtParola.clear();
        
    	long estimatedTime = System.nanoTime()-startingTime ;
    	String time = Long.toString(estimatedTime);
     	this.txtTime.appendText(time+"\n");
    	}

    	@FXML
    	void doReset(ActionEvent event) {
        long startingTime = System.nanoTime();	
    	elenco.reset();
    	txtResult.clear();
    	long estimatedTime = System.nanoTime()-startingTime ;
    	String time = Long.toString(estimatedTime);
     	this.txtTime.appendText(time+"\n");
    	}

        @FXML
        void parolaClickata(MouseDragEvent event) {
          
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

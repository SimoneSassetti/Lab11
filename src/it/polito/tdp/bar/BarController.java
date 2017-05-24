package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {
	
	private Model model;
	public void setModel(Model model) {
		this.model=model;		
	}
    
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSimula;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleSimula(ActionEvent event) {
    	
    	model.setGruppi();
    	model.run();
    	txtResult.appendText("\nRisultati:\nClienti Elaborati: "+model.getNumTotClienti()+"\n"+
    			"Clienti soddisfatti: "+model.getNumClientiSod()+"\n"+
    			"Clienti insoddisfatti: "+model.getNumClientiInsod()+".");
    }

    @FXML
    void initialize() {
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Bar.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";
    }
}

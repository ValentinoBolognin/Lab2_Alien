package it.polito.tdp.alien;

import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private AlienDictionary dizionario = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	List<String> risultato = null;
    	
    	String riga = txtWord.getText().toLowerCase();
    	StringTokenizer st = new StringTokenizer(riga, " ");
    	String parola = st.nextToken();
    	
    	if(parola != null) {
    		if(parola.matches("[a-zA-Z?]*")) {	
				if(st.hasMoreTokens()){
					String traduzione = st.nextToken();
					if(traduzione.matches("[a-zA-Z]*")) {
						dizionario.addWordEnhanced(parola, traduzione);
						txtResult.setText("Aggiunta parola "+ parola +" con traduzione "+ traduzione);
					}
					else
						txtResult.setText("Non sono consentiti caratteri alfanumerici");
				}
				else {
					risultato = dizionario.translateWordEnhanced(parola);
					if(risultato == null)
						txtResult.setText("La traduzione di "+ parola +" non e' presente nel dizionario");
					else
						txtResult.setText("La traduzione e' " + risultato);
				}
    		}
    		else
				txtResult.setText("Non sono consentiti caratteri alfanumerici");
    	}
    	else 
    		txtResult.setText("Inserire una o due parole");
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	txtWord.clear();
    	txtResult.clear();
    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}

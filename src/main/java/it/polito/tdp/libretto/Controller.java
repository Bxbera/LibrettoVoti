package it.polito.tdp.libretto;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class Controller {

	private Libretto model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> cmbPunti;

    @FXML
    private DatePicker dtpData;

    @FXML
    private TextField txtCorso;
    
    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	String corso = txtCorso.getText();
    	Integer punti = cmbPunti.getValue();  // altrimenti da null se l'utente non ha selezionato nulla, per questo l'ha lasciato Integer e non int la variabile
    	LocalDate data = dtpData.getValue();
    	
    	Voto v = new Voto(corso, punti, data);
    	this.model.add(v);
    	
    	this.txtResult.setText(model.toString());
    }
	
	public void setModel(Libretto model) {
		this.model = model;		
		this.txtResult.setText(model.toString());	// questa la aggiungo perchè avendo il DB non vuoto, come apro la finestra mi deve fare subito vedere i dati, senza aspettare di inserire
	}
	
	
    @FXML
    void initialize() {
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'main.fxml'.";
        assert dtpData != null : "fx:id=\"dtpData\" was not injected: check your FXML file 'main.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'main.fxml'.";

        for(int p=18; p<=30; p++) {
        	this.cmbPunti.getItems().add(p);
        }
    }

}

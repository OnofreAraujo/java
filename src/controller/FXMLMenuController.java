package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import view.Palco;

public class FXMLMenuController implements Initializable {

    @FXML
    void cadastro(ActionEvent event) {
        Palco.cena("cadastro");
    }

    @FXML
    void visualizar(ActionEvent event) {
        Palco.cena("visualizar");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}

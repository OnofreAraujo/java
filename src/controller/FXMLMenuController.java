package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import view.Palco;

public class FXMLMenuController implements Initializable {

    Palco palco = new Palco();
    @FXML
    void cadastro(ActionEvent event) throws IOException {
        palco.cena("cadastro");
    }

    @FXML
    void visualizar(ActionEvent event) throws IOException {
        palco.cena("visualizar");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}

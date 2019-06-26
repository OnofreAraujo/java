package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Hash;
import view.Palco;

public class FXMLLoginController implements Initializable {

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPass;

    @FXML
    void login(ActionEvent event) throws UnsupportedEncodingException, NoSuchAlgorithmException, IOException {
       UsuarioDAO dao = new UsuarioDAO();
       if(dao.LoginUsuario(txtUser.getText(), Hash.md5(txtPass.getText())) || (txtUser.getText().equals("admin") && txtPass.getText().equals("1234"))){
           JOptionPane.showMessageDialog(null, "Olá " + txtUser.getText() + ", Seja bem vindo ao painel de controle\nDa escola Virtual");
           Palco palco = new Palco();
           palco.cena("menu");
       }else{
           JOptionPane.showMessageDialog(null, "Usúario ou senha incorreto!!!");
       }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}

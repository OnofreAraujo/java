
package controller;

import dao.UsuarioDAO;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import model.Hash;
import model.Usuario;
import view.Palco;


public class FXMLCadastroUsuarioController implements Initializable {

     Usuario usuario = new Usuario();
     UsuarioDAO dao = new UsuarioDAO();
     
     
    @FXML private ImageView imagem;
    
    @FXML private TextField txtNome;
     
    @FXML private TextField txtEmail;
    
    @FXML private TextField level;

    @FXML
    private Button btSalvar;

    @FXML
    private Button btnMenu;


    @FXML
    void salvar(ActionEvent event) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        if((txtNome.getText().length() > 0) && (txtEmail.getText().length() > 0) && (level.getText().length() > 0)){
            if(isNumeric(level.getText())){
                String senha = "";
                usuario.setNome(txtNome.getText());
                usuario.setEmail(txtEmail.getText());
                usuario.setLevel(Integer.valueOf(level.getText()));
                String[] carct ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

                for(int i = 0; i < 10; i++){   
                    int j = (int) (Math.random()*carct.length);
                    senha += carct[j];
                }

                System.out.println(senha); 
                usuario.setSenha(Hash.md5(senha));

                dao.CadastrarUsuario(usuario);
                
            }else{
                JOptionPane.showMessageDialog(null, "|INFO | O campo de level só pode ser preechindo com numero");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preecha todos os campos!!!");
        }
    }
    
   @FXML void menu(ActionEvent event) {
       Palco.cena("menu");
    }
   
   @FXML void limpar(ActionEvent event) {
       txtNome.setText(null);
       txtEmail.setText(null);
       level.setText(" ");
       
       usuario.setNome(null);
       usuario.setEmail(null);
       usuario.setLevel(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
  
    private boolean isNumeric(String campo){		
	return campo.matches("[0-9]{"+campo.length()+"}");
    }
    
}

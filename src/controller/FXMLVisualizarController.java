
package controller;

import dao.UsuarioDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Usuario;
import view.Palco;

public class FXMLVisualizarController implements Initializable {
    UsuarioDAO dao = new UsuarioDAO();
    @FXML
    private TableColumn<Usuario, String> colNome;

    @FXML
    private TableView<Usuario> tabela;

    @FXML
    private TableColumn<Usuario, Integer> colLevel;

    @FXML
    private TableColumn<Usuario, String> colEmail;
    
    @FXML
    private Button btnMenu;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        
        initTabela();       
    }

   @FXML void menu(ActionEvent event) {
       Palco.cena("menu");
    }    

    public void initTabela() {
        
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colLevel.setCellValueFactory(new PropertyValueFactory<>("privilegios"));
        tabela.setItems(listaAlunos());       
    }
    
    public ObservableList<Usuario> listaAlunos(){
        List<Usuario> lista =  dao.pesquisarAll();
        return FXCollections.observableArrayList(lista);        
    }
    
}

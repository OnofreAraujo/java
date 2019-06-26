package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Usuario;
import view.Palco;

public class FXMLVisualizarController implements Initializable {

    UsuarioDAO dao = new UsuarioDAO();
    @FXML
    private TableColumn<Usuario, String> colNome;

    @FXML
    private TableColumn<Usuario, Integer> colLevel;

    @FXML
    private TableColumn<Usuario, String> colEmail;

    @FXML
    private Button btnMenu;

    @FXML
    private TableView<Usuario> tabela;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabela.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, newValue) -> itemSelecionado(newValue));
        initTabela();
    }

    @FXML
    void menu(ActionEvent event) throws IOException {
        Palco palco = new Palco();
        palco.cena("menu");
    }

    public void initTabela() {
        colNome.setEditable(true);
        colLevel.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("level"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tabela.setItems(listaUsuarios());
    }

    public ObservableList<Usuario> listaUsuarios() {
        List<Usuario> lista = dao.pesquisarAll();
        return FXCollections.observableArrayList(lista);
    }

    private void itemSelecionado(Usuario usuario) {
        usuario.setNome(usuario.getNome());
        usuario.setEmail(usuario.getEmail());
        usuario.setLevel(usuario.getLevel());
        usuario.setId(usuario.getId());
    }

    @FXML
    void alterarUser(ActionEvent event) throws IOException {
        System.out.println("ABrir a tela");
        Usuario usuario = tabela.getSelectionModel().getSelectedItem();
        if (usuario != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/FXMLEditarUsuario.fxml"));

            Stage editarStage = new Stage();
            editarStage.setTitle("Editar Usuario");
            Scene scene = new Scene(loader.load());
            editarStage.setScene(scene);

            FXMLEditarUsuarioController controller = loader.getController();
            controller.setDados(usuario);

            editarStage.showAndWait();

        } else {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERROR!");
            dialogoErro.setHeaderText("SELEICIONE UM USUARIO...");
            dialogoErro.setContentText("Por favor, selecione um usuario na lista acima!!");
            dialogoErro.showAndWait();
        }
    }

    @FXML
    void deletarUser(ActionEvent event) throws IOException {
        Usuario usuario = tabela.getSelectionModel().getSelectedItem();
        Alert delete = new Alert(AlertType.CONFIRMATION);
        delete.setTitle("DELETAR");
        delete.setHeaderText("DELETAR O USUARIO COM OS DADOS:");
        delete.setContentText("NOME: " + usuario.getNome() + "\nEMAIL: " + usuario.getEmail() + "\nLEVEL: " + usuario.getLevel());
        
        Optional<ButtonType> result = delete.showAndWait();
        if (result.get() == ButtonType.OK) {
            
            dao.deleteUsuario(usuario.getId());
            Palco palco = new Palco();
            palco.cena("visualizar");
        }
    }

}

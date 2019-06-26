package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Palco;

public class FXMLEditarUsuarioController {

    private Usuario usuario;
    UsuarioDAO dao = new UsuarioDAO();

    @FXML
    private Button btClean;

    @FXML
    private TextField level;

    @FXML
    private ImageView imagem;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btSalvar;


    @FXML
    private Button btCancel;

    @FXML
    void salvar(ActionEvent event) throws IOException {
        if ((!txtNome.getText().trim().equals("")) && (!txtEmail.getText().trim().equals("")) && (!level.getText().trim().equals(""))) {
            if (isNumeric(level.getText())) {
                String senha = "";
                usuario.setNome(txtNome.getText());
                usuario.setEmail(txtEmail.getText());
                usuario.setLevel(Integer.valueOf(level.getText()));

                Alert editado = new Alert(AlertType.INFORMATION);
                editado.setTitle("EDITAR");
                editado.setHeaderText("Usuario Editado com sucesso\nDados abaixo:");
                editado.setContentText("Nome: " + usuario.getNome() + "\nEmail: " + usuario.getEmail() + "\nNivel de Acesso: " + usuario.getLevel() + "\nOBS: A senha do usuario foi enviada para o email do mesmo!!");
                limparTela();
                editado.showAndWait();
                dao.atualizarUsuario(usuario);

                Palco palco = new Palco();
                palco.cena("visualizar");

                Stage stage = (Stage) btSalvar.getScene().getWindow();
                stage.close();

            } else {
                JOptionPane.showMessageDialog(null, "|INFO | O campo de level só pode ser preechindo com numero");
            }
        } else {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("ERROR!!");
            error.setHeaderText("Algum erro ao cadastrar");
            error.setContentText("Você precisa preecher todos os campos");
            error.showAndWait();

            if (txtNome.getText().trim().equals("")) {
                txtNome.requestFocus();
            } else if (txtEmail.getText().trim().equals("")) {
                txtEmail.requestFocus();
            } else if (level.getText().trim().equals("")) {
                level.requestFocus();
            }
        }
    }

    @FXML
    void limpar(ActionEvent event) {
        limparTela();
    }

    @FXML
    void menu(ActionEvent event) {

    }

    void setDados(Usuario user) {
        this.usuario = user;
        this.usuario.setId(user.getId());
        this.txtNome.setText(usuario.getNome());
        this.txtEmail.setText(usuario.getEmail());
        this.level.setText(String.valueOf(usuario.getLevel()));
    }

    private boolean isNumeric(String campo) {
        return campo.matches("[0-9]{" + campo.length() + "}");
    }

    private void limparTela() {
        txtNome.setText("");
        txtEmail.setText("");
        level.setText("");
    }

    @FXML
    void cancelar(ActionEvent event) {
        Stage stage = (Stage) btCancel.getScene().getWindow();
        stage.close();
    }

}

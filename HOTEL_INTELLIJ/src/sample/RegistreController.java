package sample;

import javafx.collections.ObservableList;
import sample.Models.BaseDeDatos;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Models.Usuario;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistreController implements Initializable{


    public TextField txtUserReg;
    public PasswordField txtPasswordReg;
    public Button btnExit;
    public Button btnRegister;
    public TextField txtNameReg;
    public TextField txtSurnamesReg;
    public TextField txtDNIReg;
    public TextField txtNationReg;
    public TextField txtPhoneReg;
    public TextField txtEmailReg;
    public Label errorRegister;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    public void btnExitClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void btnRegisterClick(ActionEvent actionEvent) {
        String dni = txtDNIReg.getText().trim();
        String username = txtUserReg.getText().trim();
        String email = txtEmailReg.getText().trim();
        String pwd = txtPasswordReg.getText().trim();
        String nom = txtNameReg.getText().trim();
        String cognoms = txtSurnamesReg.getText().trim();
        String nacionalitat = txtNationReg.getText().trim();
        String telefon = txtPhoneReg.getText().trim();

        if(!pwd.equals("") && !username.equals("") && !nom.equals("") && !cognoms.equals("") && !dni.equals("") && !nacionalitat.equals("") && !telefon.equals("") && !email.equals("")){
            Usuario usu = new Usuario(dni, username, email, pwd, nom, cognoms, nacionalitat, telefon, "inactive", "user");
            String insert = usu.insertarUsuari();
            if (insert.equals("dni")){
                errorRegister.setText("Aquest DNI ja s'ha registrat");
            }else if (insert.equals("usu")){
                errorRegister.setText("El nom d'usuari ja existeix");
            }else{
                Stage stage = (Stage) btnExit.getScene().getWindow();
                stage.close();
            }
        }else{
            errorRegister.setText("Si us plau ompli tots els camps.");
        }
    }

}

package sample;

import sample.Models.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginController {
    private double xOffset = 0;
    private double yOffset = 0;

    public TextField txtUser;
    public PasswordField txtPassword;
    public Button btnLogin;

    public Button btnExit;
    public Button btnRegister;
    public Label LoginErrorLabel;

    public void btnLoginClick(ActionEvent actionEvent) throws SQLException, IOException {
        String username = txtUser.getText().trim();
        String pwd = txtPassword.getText().trim();
        if(!username.equals("") && !pwd.equals("")){
            Usuario usu = new Usuario(username, pwd);
            usu.setUsername(username);
            usu.setContrasenya(pwd);
            validateLogin(usu);
        }else{
            LoginErrorLabel.setText("Please enter username and password");
        }
    }

    public void validateLogin(Usuario usu) throws IOException {

        ObservableList<Usuario> obsUsuario = usu.validateLogin();

        // System.out.println(obsUsuario);

        if (obsUsuario.isEmpty()){
            LoginErrorLabel.setText("Invalid login. Register or contact the administrator to activate your account");
        }else{

            // Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/main.fxml")));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            Parent root = loader.load();
            sample.hotelController controlador = loader.getController();
            controlador.usuParam(usu.getUsername(), usu.getContrasenya());
            Stage mainStage = new Stage();
            Scene sceneMain = new Scene(root, Color.TRANSPARENT);
            mainStage.setTitle("Hotel Junior Coast");
            mainStage.initStyle(StageStyle.TRANSPARENT);

            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {
                mainStage.setX(event.getScreenX() - xOffset);
                mainStage.setY(event.getScreenY() - yOffset);
            });
            mainStage.setScene(sceneMain);

            mainStage.show();

            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
        }

    }

    public void btnExitClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();

    }

    public void btnRegisterClick(ActionEvent actionEvent) {
        createAccount();
    }
    public void createAccount(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register_view.fxml"));
            Parent root = loader.load();

            Stage registerStage = new Stage();
            Scene sceneRegister = new Scene(root, Color.TRANSPARENT);
            registerStage.setTitle("Hotel Junior Coast");
            registerStage.initStyle(StageStyle.TRANSPARENT);
            registerStage.initModality(Modality.APPLICATION_MODAL);
            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {
                registerStage.setX(event.getScreenX() - xOffset);
                registerStage.setY(event.getScreenY() - yOffset);
            });

            registerStage.setScene(sceneRegister);
            registerStage.showAndWait();




        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}

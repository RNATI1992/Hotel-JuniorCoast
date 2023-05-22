package sample.Models;

import sample.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;

    private String dni;
    private String username;
    private String email;
    private String contrasenya;
    private String nom;
    private String cognoms;
    private String nacionalitat;
    private String telefon;
    private String estat;
    private String rol;

    public Usuario(String dni, String username, String email, String contrasenya, String nom, String cognoms, String nacionalitat, String telefon, String estat, String rol){
        this.dni = dni;
        this.username = username;
        this.email = email;
        this.contrasenya = contrasenya;
        this.nom = nom;
        this.cognoms = cognoms;
        this.nacionalitat = nacionalitat;
        this.telefon = telefon;
        this.estat = estat;
        this.rol = rol;
    }

    public Usuario(String username, String contrasenya){
        this.username = username;
        this.contrasenya = contrasenya;
    }

    public Usuario(){

    }

    public Usuario(String dni, String email, String estat){
        this.dni = dni;
        this.email = email;
        this.estat = estat;
    }



    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @FXML
    private static Connection con;

    static {
        try {
            con = BaseDeDatos.BDConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    public ObservableList<Usuario> validateLogin(){
        ObservableList<Usuario> obs = FXCollections.observableArrayList();
        try {
            Connection con = BaseDeDatos.BDConnect();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM usuari " +
                    "WHERE username = '"+ this.username + "' AND contrasenya = '"+ this.contrasenya+"' " +
                    "AND estat = 'active';");

            while(rs.next()){

                String username = rs.getString("username");
                String contrasenya = rs.getString("contrasenya");

                Usuario u = new Usuario(username, contrasenya);

                obs.add(u);

            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obs;
    }

    public String insertarUsuari(){
        String error = "";
        try {
            Connection con = BaseDeDatos.BDConnect();
            // Valida si ja existeix el dni
            ObservableList<Usuario> obsDni = FXCollections.observableArrayList();
            ResultSet rsdni = con.createStatement().executeQuery("SELECT * FROM usuari " +
                    "WHERE dni = '"+ this.dni + "';");
            while(rsdni.next()){

                String username = rsdni.getString("username");
                String contrasenya = rsdni.getString("contrasenya");

                Usuario u = new Usuario(username, contrasenya);

                obsDni.add(u);
            }
            if (!obsDni.isEmpty()){
                error = "dni";
            }
            if(error.equals("")){
                // Valida si ja existeix el nom d'usuari
                ObservableList<Usuario> obsUsername = FXCollections.observableArrayList();
                ResultSet rsusername = con.createStatement().executeQuery("SELECT * FROM usuari " +
                        "WHERE username = '"+ this.username +"';");

                while(rsusername.next()){

                    String username = rsusername.getString("username");
                    String contrasenya = rsusername.getString("contrasenya");

                    Usuario u = new Usuario(username, contrasenya);

                    obsUsername.add(u);
                }

                if (!obsUsername.isEmpty()){
                    error = "usu";
                }

            }
            // Si no s'ha trobat cap error, llavors es crea un nou usuari amb l'estat inactiu i el rol de user
            if(error.equals("")) {

                con.createStatement().executeUpdate("INSERT INTO usuari(dni, username, email, contrasenya, nom, " +
                        "cognoms, nacionalitat, telefon, estat, rol) VALUES ('" + this.dni + "','" + this.username + "'," +
                        "'" + this.email + "','" + this.contrasenya + "','" + this.nom + "','" + this.cognoms + "','" + this.nacionalitat + "'," +
                        "'" + this.telefon + "','" + this.estat + "','" + this.rol + "');");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return  error;
    }

    public String validateRol(){
        String rol = "";

        try {
            Connection con = BaseDeDatos.BDConnect();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM usuari " +
                    "WHERE username = '"+ this.username + "' AND contrasenya = '"+ this.contrasenya+"' " +
                    "AND estat = 'active';");

            while(rs.next()){

                rol = rs.getString("rol");

            }


        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rol;
    }

    public ObservableList<Usuario> listarUsuarios(){
        ObservableList<Usuario> obsUsuario = FXCollections.observableArrayList();
        try {
            // Abro la conexion
            Connection con = BaseDeDatos.BDConnect();
            // Realizo la consulta
            ResultSet rs = con.createStatement().executeQuery("SELECT dni, email, estat FROM usuari " +
                    "WHERE username != 'admin' AND estat = 'inactive';");
            // Recorro los resultados
            while(rs.next()){
                // Cojo los datos
                String dni = rs.getString("dni");
                String email = rs.getString("email");
                String estat = rs.getString("estat");

                // Creo el bungalow
                Usuario usu = new Usuario(dni, email, estat);

                obsUsuario.add(usu);

            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obsUsuario;
    }

    public void validateUsuari(){
        try {
            Connection con = BaseDeDatos.BDConnect();

            con.createStatement().executeUpdate("UPDATE usuari SET estat = 'active' WHERE dni = '"+this.dni+ "';");


        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteUsuari(){
        try {
            Connection con = BaseDeDatos.BDConnect();

            con.createStatement().executeUpdate("DELETE FROM usuari WHERE dni = '"+this.dni+ "';");


        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

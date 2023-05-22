package sample.Models;

import sample.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Initializable {

    private String dni;
    private String email;
    private String nom;
    private String cognoms;
    private String nacionalitat;
    private String telefon;
    private String ocupacio;
    private String estat_civil;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public Cliente(){

    }

    public Cliente(String dni){
        this.dni = dni;
    }

    public Cliente(String dni, String email, String nom, String cognoms, String nacionalitat, String telefon, String ocupacio, String estat_civil){
        this.dni = dni;
        this.email = email;
        this.nom = nom;
        this.cognoms = cognoms;
        this.nacionalitat = nacionalitat;
        this.telefon = telefon;
        this.ocupacio = ocupacio;
        this.estat_civil = estat_civil;

    }
    // Getters & Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getOcupacio() {
        return ocupacio;
    }

    public void setOcupacio(String ocupacio) {
        this.ocupacio = ocupacio;
    }

    public String getEstat_civil() {
        return estat_civil;
    }

    public void setEstat_civil(String estat_civil) {
        this.estat_civil = estat_civil;
    }



    public void insertarCliente(){
        try {
            Connection con = BaseDeDatos.BDConnect();

            con.createStatement().executeUpdate("INSERT INTO client(dni, email, nom, cognoms, nacionalitat, telefon, ocupacio, estat_civil) " +
                    "VALUES ('" + this.dni + "','" + this.email + "','" + this.nom + "'," +
                    "'" + this.cognoms + "','" + this.nacionalitat + "','" + this.telefon + "','" + this.ocupacio +"','" + this.estat_civil +"');");


        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Cliente> listarClientes(){
        ObservableList<Cliente> obsCliente = FXCollections.observableArrayList();
        try {
            // Abro la conexion
            Connection con = BaseDeDatos.BDConnect();
            // Realizo la consulta
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM client ;");
            // Recorro los resultados
            while(rs.next()){
                // Cojo los datos
                String dni = rs.getString("dni");
                String email = rs.getString("email");
                String nom = rs.getString("nom");
                String cognoms = rs.getString("cognoms");
                String nacionalitat = rs.getString("nacionalitat");
                String telefon = rs.getString("telefon");
                String ocupacio = rs.getString("ocupacio");
                String estat_civil = rs.getString("estat_civil");


                // Creo el cliente
                Cliente cli = new Cliente(dni, email, nom, cognoms, nacionalitat, telefon, ocupacio, estat_civil);

                obsCliente.add(cli);

            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obsCliente;
    }

    public Boolean validateDni(){
        Boolean repetit = false;

        try {
            Connection con = BaseDeDatos.BDConnect();
            ObservableList<Cliente> obsDniCliente = FXCollections.observableArrayList();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM client " +
                    "WHERE dni  = '"+ this.dni + "';");

            while(rs.next()){

                String dni = rs.getString("dni");
                String email = rs.getString("email");
                String nom = rs.getString("nom");
                String cognoms = rs.getString("cognoms");
                String nacionalitat = rs.getString("nacionalitat");
                String telefon = rs.getString("telefon");
                String ocupacio = rs.getString("ocupacio");
                String estat_civil = rs.getString("estat_civil");

                // Creo el cliente
                Cliente cli = new Cliente(dni, email, nom, cognoms, nacionalitat, telefon, ocupacio, estat_civil);

                obsDniCliente.add(cli);

            }
            // Si no esta vacío repetit = true
            if (!obsDniCliente.isEmpty()){
                repetit = true;
            }


        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return repetit;
    }

    public void updateCliente(){
        try {
            Connection con = BaseDeDatos.BDConnect();

            con.createStatement().executeUpdate("UPDATE client SET email = '" + this.email +
                    "', nom = '"+this.nom+"', cognoms = '"+this.cognoms+"' , nacionalitat= '"+this.nacionalitat+ "' , telefon= '"+this.telefon+
                    "' , ocupacio= '"+this.ocupacio+"' , estat_civil= '"+this.estat_civil+
                    "' WHERE dni = '"+this.dni+ "';");


        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCliente(){
        try {
            Connection con = BaseDeDatos.BDConnect();

            con.createStatement().executeUpdate("DELETE FROM client WHERE dni = '"+this.dni+ "';");


        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

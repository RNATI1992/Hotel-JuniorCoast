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

public class Bungalow implements Initializable {

    private String num_bungalow;
    private String caracteristiques;
    private String preu;
    private String estat;
    private String tipus_bungalow;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public Bungalow(){

    }

    public Bungalow(String num_bungalow){
        this.num_bungalow = num_bungalow;
    }

    public Bungalow(String num_bungalow, String caracteristiques, String preu, String estat, String tipus_bungalow){
        this.num_bungalow = num_bungalow;
        this.caracteristiques = caracteristiques;
        this.preu = preu;
        this.estat = estat;
        this.tipus_bungalow = tipus_bungalow;

    }
    // Getters & Setters
    public String getNum_bungalow() {
        return num_bungalow;
    }

    public void setNum_bungalow(String num_bungalow) {
        this.num_bungalow = num_bungalow;
    }
    public String getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(String caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public String getPreu() {
        return preu;
    }

    public void setPreu(String preu) {
        this.preu = preu;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public String getTipus_bungalow() {
        return tipus_bungalow;
    }

    public void setTipus_bungalow(String tipus_bungalow) {
        this.tipus_bungalow = tipus_bungalow;
    }

    public void insertarBungalow(){
        try {
            Connection con = BaseDeDatos.BDConnect();

            con.createStatement().executeUpdate("INSERT INTO bungalow(num_bungalow, caracteristiques, preu, estat, tipus_bungalow) " +
                    "VALUES ('" + this.num_bungalow + "','" + this.caracteristiques + "','" + this.preu + "'," +
                        "'" + this.estat + "','" + this.tipus_bungalow +"');");


        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Bungalow> listarBungalows(){
        ObservableList<Bungalow> obsBungalow = FXCollections.observableArrayList();
        try {
            // Abro la conexion
            Connection con = BaseDeDatos.BDConnect();
            // Realizo la consulta
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM bungalow ;");
            // Recorro los resultados
            while(rs.next()){
                // Cojo los datos
                String num_bungalow = rs.getString("num_bungalow");
                String caracteristiques = rs.getString("caracteristiques");
                String preu = rs.getString("preu");
                String estat = rs.getString("estat");
                String tipus_bungalow = rs.getString("tipus_bungalow");

                // Creo el bungalow
                Bungalow bung = new Bungalow(num_bungalow, caracteristiques, preu, estat, tipus_bungalow);

                obsBungalow.add(bung);

            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obsBungalow;
    }

    public Boolean validateNumBungalow(){
        Boolean repetit = false;

        try {
            Connection con = BaseDeDatos.BDConnect();
            ObservableList<Bungalow> obsNumBungalow = FXCollections.observableArrayList();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM bungalow " +
                    "WHERE num_bungalow  = '"+ this.num_bungalow + "';");

            while(rs.next()){

                String num_bungalow = rs.getString("num_bungalow");
                String caracteristiques = rs.getString("caracteristiques");
                String preu = rs.getString("preu");
                String estat = rs.getString("estat");
                String tipus_bungalow = rs.getString("tipus_bungalow");

                // Creo el bungalow
                Bungalow bung = new Bungalow(num_bungalow, caracteristiques, preu, estat, tipus_bungalow);

                obsNumBungalow.add(bung);

            }
            // Si no esta vacío repetit = true
            if (!obsNumBungalow.isEmpty()){
                repetit = true;
            }


        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return repetit;
    }

    public void updateBungalow(){
        try {
            Connection con = BaseDeDatos.BDConnect();

            con.createStatement().executeUpdate("UPDATE bungalow SET caracteristiques = '" + this.caracteristiques +
                    "', preu = '"+this.preu+"', estat = '"+this.estat+"' , tipus_bungalow= '"+this.tipus_bungalow+
                    "' WHERE num_bungalow = '"+this.num_bungalow+ "';");


        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteBungalow(){
        try {
            Connection con = BaseDeDatos.BDConnect();

            con.createStatement().executeUpdate("DELETE FROM bungalow WHERE num_bungalow = '"+this.num_bungalow+ "';");


        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

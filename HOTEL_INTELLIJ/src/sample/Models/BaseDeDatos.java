/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author daw1b
 */
public class BaseDeDatos {
    
    public static Connection BDConnect() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
    }
    
}

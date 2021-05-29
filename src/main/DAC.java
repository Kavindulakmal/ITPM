/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Avilon
 */
public class DAC {
    Connection con;
    public Connection getConnection() {
        // Get the connection string and fill these accordingly.
        //Connection string: jdbc:mysql://localhost:3306/sllit?zeroDateTimeBehavior=convertToNull
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sliit";
        String username = "root";
        String password = "";
        
        // Try to connect to the MySQL db
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return con;
    }
}

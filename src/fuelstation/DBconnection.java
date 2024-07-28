/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuelstation;

import java.sql.*;  
import javax.swing.JOptionPane;

/**
 *
 * @author Rasha
 */
public class DBconnection {
    public static Connection connect(){ 
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelstation","root","");  
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
}

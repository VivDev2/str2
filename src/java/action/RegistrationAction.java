/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MCA-16
 */
public class RegistrationAction {
    String id,pass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String execute() throws SQLException{
    
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrationAction.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","admin");
           Statement stmt=con.createStatement();
           int s=stmt.executeUpdate("insert into lg values("+id+",'"+pass+"')");
           if(s>0){
            return "success";
           }
            else{ 
            return "fail";
                    }   
                    
           }
        
    
    }


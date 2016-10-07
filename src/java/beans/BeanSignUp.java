/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.ConnectionPool;
import classes.Customer;
import classes.Helpers;
import classes.InputCheck;
import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cdi307
 */
public class BeanSignUp implements Serializable {
    
   
    public boolean check(String surname, String firstname, String pwd,
            String mail, String cell, Date dob) {

        if (surname == null) {
            return false;
        }

        if (surname.trim().isEmpty()) {
            return false;
        }

        if (firstname == null) {
            return false;
        }

        if (firstname.trim().isEmpty()) {
            return false;
        }

        if (pwd == null) {
            return false;
        }

        if (pwd.trim().isEmpty()) {
            return false;
        }

        if (mail == null) {                     //REGEX A INCLURE
            return false;
        }

        if (mail.trim().isEmpty()) {
            return false;
        }

        if (cell == null) {
            return false;
        }

        if (cell.trim().isEmpty()) {
            return false;
        }

        if (dob == null) {
            return false;
        }
        //pas de trim sur la date, regex à inclure pour le format de date
    
        return false; 
    
    }
        ///////////////////////////////////////////////////////////////////////

        //Insertion des champs dans la bdd
        
    public boolean insertSignUp(String surname, String firstname, String pwd,
            String mail, String cell, String landline, Date dob) {
        boolean retour = false;
        ConnectionPool cp = new ConnectionPool();
        try (Connection cnn = cp.setConnection();) {

            String query = "INSERT INTO [starbook].[dbo].[sb_customer] VALUES ("
                    + " ?,?,?,?,?,?,?)";

            
            PreparedStatement pstmt = cnn.prepareStatement(query);
            pstmt.setString(1, surname);
            pstmt.setString(2, firstname);
            pstmt.setString(3, pwd);
            pstmt.setString(4, mail);
            pstmt.setString(5, cell);
            pstmt.setString(6, landline);
            pstmt.setDate(7, Helpers.convertUtiltoSQLDate(dob));

            pstmt.execute();
            pstmt.close();
            retour = true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retour;
    }

  

           
    
}

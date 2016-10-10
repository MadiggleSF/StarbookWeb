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
    
   
    public int check(String surname, String firstname, String pwd,
            String mail, String cell,String landline, Date dob) {
        
        int r = 1;
        
        //contraintes de saisie du nom de famille (ni null, ni vide,regex)
        if (surname == null || surname.trim().isEmpty() 
                            || (!InputCheck.checkAlphaChar(surname))){
            return 1;
        }

        //contraintes de saisie du prénom
        if (firstname == null || firstname.trim().isEmpty()
                              || (!InputCheck.checkAlphaChar(firstname))) {
            return 2;
        }

        //contraintes de saisie du pwd
        if (pwd == null || pwd.trim().isEmpty()) {
            return 3;
        }

        //contraintes de saisie du mail
        if (mail == null || mail.trim().isEmpty()
                         || (!InputCheck.checkMail(mail))){                     
            return 4;
        }

        //contraintes de saisie du cell 
        if (cell == null || cell.trim().isEmpty()
                         || (! InputCheck.checkPhone(cell))) {
            return 5;
        }

        //contraintes de saisie du landline(champ non obligatoire, format regex)
        
        if (!InputCheck.checkNumbers_NotMandatory(landline)){
            return 6;
        }

        //contraintes de saisie du dob
        if (dob == null) {
            return 7;
        }
        
    
        return r; 
    
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

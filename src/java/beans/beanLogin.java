package beans;

import classes.ConnectionPool;
import classes.InputCheck;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Gab
 */
public class BeanLogin implements Serializable {
    
    
    
    public int check(String login, String password) {
        int r = 1;
        
        //contraintes de saisie du login (ni null, ni vide, regex)
        if (login == null ||(!InputCheck.checkMail(login))
                          ||(login.trim().isEmpty())) {
            return 1;
        }
        
        //contraintes de saisie du pwd (ni null, ni vide)
        if (password == null||(password.trim().isEmpty())) {
            return 2 ;
        }
       
       
       
        // Verification du login et du mot de passe dans la bdd
        ConnectionPool cp = new ConnectionPool();

        try (Connection cnn = cp.setConnection();) {
            String query = " SELECT customer_pwd, customer_mail FROM [starbook].[dbo].[sb_customer];";

            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

               
                // cas où le mail n'existe pas dans la base de données
                if (!rs.getString("customer_mail").equals(login)) {
                    r = 3;
                }
                
                // cas où le mail existe mais le mot de passe est incorrect 
                if (rs.getString("customer_mail").equals(login)
                        && !rs.getString("customer_pwd").equals(password)){
                    r = 4;
                }
                        
                
                // cas où le login et le mot de passe sont corrects
                if (rs.getString("customer_mail").equals(login) 
                        && rs.getString("customer_pwd").equals(password)){
                    
                        return 0;
                }
                
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;

    }

    //        ConnectionPool cp = new ConnectionPool();
//        try (Connection cnn = cp.setConnection();) {
//        String query = "";
//        
//        /////////////////
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
//        }
}

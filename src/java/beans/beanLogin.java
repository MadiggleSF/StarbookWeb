package beans;


import classes.ConnectionPool;
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

    public boolean check(String login, String password) {
        if (login == null) {
            return false;
        }
        if (password == null) {
            return false;
        }
        if (login.trim().isEmpty()) {
            return false;
        }
        if (password.trim().isEmpty()) {
            return false;
        }

//         if (login.equals("admin")) {
//            if (password.equals("root")) {
//                return true;
//            }
//        }
//        
        // Verification du login et du mot de passe dans la bdd
        ConnectionPool cp = new ConnectionPool();

         
        
        try (Connection cnn = cp.setConnection();) {
            String query = " SELECT customer_pwd, customer_mail FROM [starbook].[dbo].[sb_customer];";

            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                System.out.println(rs.getString("customer_mail") + " " + rs.getString("customer_pwd"));
                if (rs.getString("customer_mail").equals(login)) {
                    if (rs.getString("customer_pwd").equals(password)) {
                        return true;
                    }
                }
            }

            rs.close();
            stmt.close();
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
      
        
        return false;

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

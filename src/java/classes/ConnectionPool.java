package classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {

    private InitialContext ic = null;
    private DataSource ds = null;

    public Connection setConnection() throws SQLException {
        try {
            ic = new InitialContext();
        } catch (NamingException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ds = (DataSource) ic.lookup("jdbc/starbook");
        } catch (NamingException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds.getConnection();
    }
   
}



// -----------  UTILISATION  --------------
//        ConnectionPool cp = new ConnectionPool();
            
//        try (Connection cnn = cp.setConnection();) {
//        String query = "";
//        
//        /////////////////
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
//        }

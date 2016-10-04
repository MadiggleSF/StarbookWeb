package beans;

import classes.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class beanOrderAddress implements Serializable {

   

    private HashMap<String, Address> map;
    ConnectionPool cp = new ConnectionPool();

    public Address getBilling() {
        
        Address a1 = null;
            try (Connection cnn = cp.setConnection();) {
        String query = "select * from sb_address where address_id = 1;";
        Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                a1 = new Address(rs.getInt("address_id"),
                        
                        rs.getString("address_street"),
                        rs.getString("address_other"),
                        rs.getString("address_zipcode"),
                        rs.getString("address_city"),
                        rs.getString("address_country"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return a1;
    }

    private void getDelivery() {

    }

    private void getAll() {
        getBilling();
        getDelivery();
    }

    private Collection<Address> list() {
        return map.values();
    }
}

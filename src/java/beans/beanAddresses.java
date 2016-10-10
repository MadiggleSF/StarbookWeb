package beans;

import classes.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class beanAddresses implements Serializable {

    ConnectionPool cp = new ConnectionPool();
    HashMap<String, Address> map;

    public beanAddresses() {
        map = new HashMap<>();
    }
    
     
    
    public void getCustomerAddresses(String login) {
        getCustomerDelivery(login);
        getCustomerBill(login);
    }
    
    public Collection<Address> list(){
        return map.values();
    }
    
    public Address getAddress(int id){
        return map.get(String.valueOf(id));
    }
    
    public void getCustomerBill(String login) {
        try (Connection cnn = cp.setConnection();) {

            String query = "SELECT * FROM viewCustomerBills WHERE customer_mail = '"+login+"'";
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                map.put(String.valueOf(rs.getInt("address_id")),
                        (new Address(rs.getInt("address_id"),
                        rs.getString("address_street"),
                        rs.getString("address_other"),
                        rs.getString("address_zipcode"),
                        rs.getString("address_city"),
                        rs.getString("address_country"))));
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getCustomerDelivery(String login) {
        
        try (Connection cnn = cp.setConnection();) {

            String query = "SELECT * FROM viewCustomerDeliveries WHERE customer_mail = '"+login+"'";
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                map.put(String.valueOf(rs.getInt("address_id")),
                        (new Address(rs.getInt("address_id"),
                        rs.getString("address_street"),
                        rs.getString("address_other"),
                        rs.getString("address_zipcode"),
                        rs.getString("address_city"),
                        rs.getString("address_country"))));
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  

    public void createDelivery() {

    }
    
    public void createBilling() {

    }

    public void modify() {

    }

    public void remove() {

    }

    public int getCustomerID(String login) {

        int id = 0;
        try (Connection cnn = cp.setConnection();) {
            String query = "select * from sb_customer WHERE customer_mail = '"+login+"'";

            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                id = rs.getInt("customer_id");
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}

package beans;

import classes.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class beanAddresses implements Serializable {

    ConnectionPool cp = new ConnectionPool();
    HashMap<String, Address> map;

//    public void getCustomerBill(int id) {
//        try (Connection cnn = cp.setConnection();) {
//
//            String query = "";
//            Statement stmt = cnn.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//                map.add(new Address(rs.getInt("employee_id"),
//                        rs.getInt("status_number"),
//                        rs.getDate("status_date")));
//            }
//            rs.close();
//            stmt.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    public void getCustomerDelivery(int id) {

    }

    public void getCustomerAddresses() {

    }

    public void create() {

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

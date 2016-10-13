package beans;

import classes.Address;
import classes.ConnectionPool;
import classes.Customer;
import classes.Order;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class beanProfile implements Serializable {

    private Customer customer;
    private HashMap<String, Order> orders;

    public beanProfile() {
        customer = new Customer();
        orders = new HashMap<>();
    }

    
    
    //Customer
    public Customer fillCustomer(String login) {
        //Customer customer = new Customer();
        ConnectionPool cp = new ConnectionPool();

        try (Connection co = cp.setConnection()) {

            String query = "SELECT * FROM [starbook].[dbo].[sb_customer] WHERE sb_customer.customer_mail = '" + login + "'";
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                customer.setId(rs.getInt("customer_id"));
                customer.setSurname(rs.getString("customer_surname"));
                customer.setFirstname(rs.getString("customer_firstname"));
                customer.setPwd(rs.getString("customer_pwd"));
                customer.setMail(rs.getString("customer_mail"));
                customer.setCell(rs.getString("customer_cell"));
                customer.setLandline(rs.getString("customer_landline"));
                customer.setDob(rs.getDate("customer_dob"));

            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Error: SQLException: " + ex.getMessage());
        }

        return customer;

    }

    //Commandes
    public Collection<Order> getOrders() {

        String query = "SELECT * FROM sb_order where sb_order.customer_id = " + customer.getId();
        ConnectionPool cp = new ConnectionPool();

        try (Connection co = cp.setConnection()) {
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                orders.put(String.valueOf(rs.getInt("order_id")),
                        new Order((rs.getInt("order_id")),
                                customer, rs.getDate("order_date"),
                                null, rs.getString("order_comments")));

            }
            
        rs.close();
        stmt.close();
        
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: method getOrders: "+ex.getMessage());
        }
            return orders.values();// retourne les valeurs de la hashmap sous forme de collection 
    }

    
   
    
    
    
}

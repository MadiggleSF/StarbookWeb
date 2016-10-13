
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


public class beanOrder implements Serializable {
    
    private HashMap<String, CartLine> col;
    private ConnectionPool cp = new ConnectionPool();

    public beanOrder() {
        this.col = new HashMap<>();
    }
        
    
    public void fill(Collection<CartLine> cart){
        for(CartLine c : cart){
            add(c);
        }
    }
    
    public void add(CartLine c){
        if(!col.isEmpty()){
            for(CartLine i : col.values()){
                if(i.getIsbn().equals(c.getIsbn())){
                    c.setQty(c.getQty()+i.getQty());
                    col.remove(i);
                    break;
                }                
            }
        }
        col.put(c.getIsbn(), c);
    }
    
    public float getFinalPrice(){
        float p = 0f;
        for(CartLine i : col.values()){
           p += i.getFinalLinePrice();
        }
        return p;
    }
    
    public int size(){
        return col.size();
    }
    
    public void makeOrder(String login, int idAddressD, int idAddressB){
        int idCustomer = getCustomerID(login);
        saveOrder(idCustomer);
        int idOrder = getOrderID();
        saveLines(idOrder);
        setOrderDelivery(idAddressD, idOrder);
        setOrderBilling(idAddressB, idOrder);
        setOrderStatus(idOrder);
        
    }
    
    public void saveOrder(int idCustomer){
        try (Connection cnn = cp.setConnection();) {
            String query = "insert into sb_order (customer_id, order_date, order_ipAddress, order_comments) values (?, GETDATE(), ?, ?)";

            PreparedStatement pstmt = cnn.prepareStatement(query);
            pstmt.setInt(1, idCustomer);
            pstmt.setString(2, "");
            pstmt.setString(3, "");

            pstmt.execute();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public int getOrderID(){
        int id = 0;
         try (Connection cnn = cp.setConnection();) {
            String query = "select * from sb_order";

            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                id = rs.getInt("order_id");
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return id;
    }
    
    public void saveLines(int idOrder){
        for(CartLine c : col.values()){
            try (Connection cnn = cp.setConnection();) {
            String query = "insert into sb_orderLine "
                    + "(order_id, book_isbn, order_itemQty, order_unitPrice, order_taxRate, order_discountRate) "
                    + "values (?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = cnn.prepareStatement(query);
            pstmt.setInt(1, getOrderID());
            pstmt.setString(2, c.getIsbn());
            pstmt.setInt(3, c.getQty());
            pstmt.setFloat(4, c.getBookPrice());
            pstmt.setFloat(5, c.getTax().getRate());
            pstmt.setFloat(6, c.getDiscountRate());

            pstmt.execute();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
        
    
    public void setOrderStatus(int idOrder){
        try (Connection cnn = cp.setConnection();) {
            String query = "insert into sb_orderStatus (status_number, order_id, status_date) values (?, ?, GETDATE())";

            PreparedStatement pstmt = cnn.prepareStatement(query);
            pstmt.setInt(1, 102);
            pstmt.setInt(2, idOrder);

            pstmt.execute();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setOrderDelivery(int idAdressD, int idOrder){
        try (Connection cnn = cp.setConnection();) {
            String query = "insert into sb_orderDelivery values (?, ?, GETDATE())";

            PreparedStatement pstmt = cnn.prepareStatement(query);
            pstmt.setInt(1, idAdressD);
            pstmt.setInt(2, idOrder);

            pstmt.execute();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setOrderBilling(int idAdressB, int idOrder){
        try (Connection cnn = cp.setConnection();) {
            String query = "insert into sb_orderBill values (?, ?, GETDATE())";

            PreparedStatement pstmt = cnn.prepareStatement(query);
            pstmt.setInt(1, idAdressB);
            pstmt.setInt(2, idOrder);

            pstmt.execute();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getCustomerID(String login) {

        int id = 0;
        try (Connection cnn = cp.setConnection();) {
            String query = "select * from sb_customer WHERE customer_mail = '" + login + "'";

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

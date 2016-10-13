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

    public Collection<Address> list() {
        return map.values();
    }

    public Address getAddress(int id) {
        return map.get(String.valueOf(id));
    }

    public void getCustomerBill(String login) {
        try (Connection cnn = cp.setConnection();) {

            String query = "SELECT * FROM viewCustomerBills WHERE customer_mail = '" + login + "'";
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

            String query = "SELECT * FROM viewCustomerDeliveries WHERE customer_mail = '" + login + "'";
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

    public void insertAddress(Address a) {

        try (Connection cnn = cp.setConnection();) {

            String query = "insert into sb_address "
                    + "(address_street, address_other, address_zipcode, address_city, address_country) "
                    + "values (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = cnn.prepareStatement(query);
            pstmt.setString(1, a.getStreet());
            pstmt.setString(2, a.getOther());
            pstmt.setString(3, a.getZipcode());
            pstmt.setString(4, a.getCity());
            pstmt.setString(5, a.getCountry());

            pstmt.execute();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getAddressID(Address a) {
        int id = 0;
        try (Connection cnn = cp.setConnection();) {
            String query = "select * from sb_address where "
                    + "address_street = '" + a.getStreet() + "' AND "
                    + "address_other = '" + a.getOther() + "' AND "
                    + "address_zipcode = '" + a.getZipcode() + "' AND "
                    + "address_city = '" + a.getCity() + "' AND "
                    + "address_country = '" + a.getCountry() + "'";

            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                id = rs.getInt("address_id");
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    public void setDelivery(String login, Address a) {
        int customerID = getCustomerID(login);
        int addressID = getAddressID(a);
        try (Connection cnn = cp.setConnection();) {
            String query = "insert into sb_customerDelivery values (?, ?, GETDATE())";

            PreparedStatement pstmt = cnn.prepareStatement(query);
            pstmt.setInt(1, customerID);
            pstmt.setInt(2, addressID);

            pstmt.execute();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setBilling(String login, Address a) {
        int customerID = getCustomerID(login);
        int addressID = getAddressID(a);

        try (Connection cnn = cp.setConnection();) {
            String query = "insert into sb_customerBill values (?, ?, GETDATE())";

            PreparedStatement pstmt = cnn.prepareStatement(query);
            pstmt.setInt(1, customerID);
            pstmt.setInt(2, addressID);

            pstmt.execute();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(int id, String street, String zipcode, String city, String country, String other) {
        try (Connection cnn = cp.setConnection();) {
            String query = "update sb_address set "
                    + "address_street = ?, "
                    + "address_city = ?, "
                    + "address_zipcode = ?, "
                    + "address_country = ?, "
                    + "address_other = ? "
                    + "where address_id = ?";

            PreparedStatement pstmt = cnn.prepareStatement(query);
            pstmt.setString(1, street);
            pstmt.setString(2, city);
            pstmt.setString(3, zipcode);
            pstmt.setString(4, country);
            pstmt.setString(5, other);
            pstmt.setInt(6, id);

            pstmt.execute();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(int id) {
        removeD(id);
        removeB(id);
    }

    public void removeD(int id) {

        try (Connection cnn = cp.setConnection();) {
            String query = "DELETE FROM sb_customerDelivery WHERE address_id = ?";

            PreparedStatement pstmt = cnn.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.execute();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeB(int id) {

        try (Connection cnn = cp.setConnection();) {
            String query = "DELETE FROM sb_customerBill WHERE address_id = ?";

            PreparedStatement pstmt = cnn.prepareStatement(query);
            pstmt.setInt(1, id);

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

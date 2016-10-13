/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Book;
import classes.ConnectionPool;
import classes.Customer;
import classes.OrderLine;
import classes.Publisher;
import classes.Review;
import classes.Tax;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author cdi314
 */
public class beanReview implements Serializable{

    private String bookRating;
    private Review review;
    private HashMap<String, Review> reviews;

    public beanReview() {
        review = new Review();
        reviews = new HashMap<>();
        bookRating = "";
    }

    public Review getReview() {
        return review;
    }

    public HashMap<String, Review> getReviews() {
        return reviews;
    }

    public Collection<Review> getReviewsList() {
        return reviews.values();
    }
    
    public String getBookRating(){
        return bookRating;
    }

    public void setBookRating(String input) {
        reviews.clear();
        float bookRating =0;
        setReviewsFromDB(input, 1);
        for (Review r : reviews.values()) {
            bookRating += r.getRating();
        }
        if (reviews.size()>0) {
            bookRating = bookRating / reviews.size();
        }else{
            bookRating = 11;
        }
        this.bookRating = String.format("%.2g%n", bookRating);
    }

    public void setReviewsFromDB(String input, int type) {
        String query = "SELECT * "
                + "FROM sb_review,sb_book,sb_customer,sb_orderLine,sb_order,sb_publisher, sb_tax "
                + "WHERE sb_review.orderLine_id = sb_orderLine.orderLine_id "
                + "AND sb_orderLine.order_id = sb_order.order_id "
                + "AND sb_order.customer_id = sb_customer.customer_id "
                + "AND sb_review.customer_id = sb_customer.customer_id "
                + "AND sb_review.book_isbn = sb_book.book_isbn "
                + "AND sb_book.publisher_isbn = sb_publisher.publisher_isbn ";

        switch (type) {
            case 1:
                query += "AND sb_book.book_isbn = '" + input + "'";
                break;
            case 2:
                query += "AND sb_customer.customer_id = " + input;
                break;
        }

        ConnectionPool cp = new ConnectionPool();
        try (Connection co = cp.setConnection()) {
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                reviews.put(String.valueOf(rs.getInt("review_id")),
                        new Review(rs.getInt("review_id"),
                                new Book(rs.getString("book_isbn"),
                                        new Publisher(rs.getString("publisher_isbn"),
                                                rs.getString("publisher_name")),
                                        rs.getString("book_title"),
                                        rs.getString("book_subtitle"),
                                        rs.getDate("book_date"),
                                        rs.getString("book_picture"),
                                        rs.getString("book_summary"),
                                        rs.getString("book_idiom"),
                                        rs.getFloat("book_price"),
                                        new Tax(rs.getInt("tax_id"),
                                                rs.getString("tax_name"),
                                                rs.getFloat("tax_rate")),
                                        rs.getInt("book_quantity"),
                                        rs.getString("book_pages"),
                                        rs.getString("book_print"),
                                        rs.getInt("book_weight")),
                                new Customer(rs.getInt("customer_id"),
                                        rs.getString("customer_surname"),
                                        rs.getString("customer_firstname"),
                                        rs.getString("customer_pwd"),
                                        rs.getString("customer_mail"),
                                        rs.getString("customer_cell"),
                                        rs.getString("customer_landline"),
                                        rs.getDate("customer_dob")), 
                                new OrderLine(rs.getInt("orderLine_id"),
                                        rs.getString("book_isbn"),
                                        rs.getInt("order_itemQty"),
                                        rs.getFloat("order_unitPrice"),
                                        rs.getFloat("order_taxRate"),
                                        rs.getFloat("order_discountRate")), 
                                rs.getString("review_comment"), 
                                rs.getInt("review_rating"), 
                                rs.getDate("review_date")));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: " + ex.getMessage());
        }
    }
    
    public boolean insertReview(String book_isbn, int customer_id, int orderLine_id, String comment, int rating){
        Boolean b = false;
        ConnectionPool cp = new ConnectionPool();
        String query = "INSERT INTO sb_review "
                + "VALUES(?,?,?,?,?,GETDATE())";
        
        try (Connection co = cp.setConnection()){
            PreparedStatement stmt = co.prepareStatement(query);
            stmt.setString(1, book_isbn);
            stmt.setInt(2, customer_id);
            stmt.setInt(3, orderLine_id);
            stmt.setString(4, comment);
            stmt.setInt(5, rating);
            stmt.execute();
            b= true;
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: method insertReview"+ex.getMessage());
        }
        return b;
    }
    
    public boolean checkHasOrdered(String customer_mail, String isbn){
        Boolean b = false;
        String query = "SELECT *  FROM sb_customer, sb_order, sb_orderLine "
                + "WHERE sb_customer.customer_id = sb_order.customer_id "
                + "AND sb_order.order_id = sb_orderLine.order_id "
                + "AND sb_customer.customer_mail = '"+customer_mail+"' "
                + "AND sb_orderLine.book_isbn = '"+isbn+"'";
        
        ConnectionPool cp = new ConnectionPool();
        try (Connection co = cp.setConnection()){
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                b = true;
            }
            
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: method checkHasOrdered"+ex.getMessage());
        }
        return b;
    }
    
    public int getOrderLineId(String customer_mail, String isbn){
        int b = 0;
        String query = "SELECT *  FROM sb_customer, sb_order, sb_orderLine "
                + "WHERE sb_customer.customer_id = sb_order.customer_id "
                + "AND sb_order.order_id = sb_orderLine.order_id "
                + "AND sb_customer.customer_mail = '"+customer_mail+"' "
                + "AND sb_orderLine.book_isbn = '"+isbn+"'";
        
        ConnectionPool cp = new ConnectionPool();
        try (Connection co = cp.setConnection()){
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                b = rs.getInt("orderLine_id");
            }
            
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: method getOrderLineId"+ex.getMessage());
        }
        return b;
    
    }
    
    

}

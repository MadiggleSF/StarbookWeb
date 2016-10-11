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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author cdi314
 */
public class beanReview {
    
    private HashMap<String,Integer> rating;
    private Review review;
    private HashMap<String,Review> reviews;

    public beanReview() {
        review = new Review();
        reviews = new HashMap<>();
        rating = new HashMap<>();
    }

    public Review getReview() {
        return review;
    }

    public HashMap<String, Review> getReviews() {
        return reviews;
    }
    
    public Collection<Review> getReviewsList(){
        return reviews.values();
    }
    
    public Collection<Integer> getRatingList(){
        return rating.values();
    }
    
    public int getBookRating(){
        int rate = 0;
        for (Review r : reviews.values()) {
            rate+=r.getRating();
        }
        if (reviews.size()>0) {
            return rate/reviews.size();
        }else{
            return 0;
        }
        
    }
    
    public void setBookRating(String isbn, int rating){
        this.rating.put(isbn, rating);
    }
    
    public void setReviewsFromDB(String input, int type){
        String query = "SELECT * "
                + "FROM sb_review,sb_book,sb_customer,sb_orderLine,sb_order,sb_publisher, sb_tax "
                + "WHERE sb_review.orderLine_id = sb_orderLine.orderLine_id "
                + "AND sb_orderLine.order_id = sb_order.order_id "
                + "AND sb_order.customer_id = sb_customer.customer_id "
                + "AND sb_review.customer_id = sb_customer.customer_id "
                + "AND sb_review.book_isbn = sb_book.book_isbn "
                + "AND sb_book.publisher_isbn = sb_publisher.publisher_isbn ";
        
        switch(type){
            case 1:
                query+="AND sb_book.book_isbn = '"+input+"'";
                break;
            case 2:
                query+="AND sb_customer.customer_id = "+input;
                break;
        }
        
        ConnectionPool cp = new ConnectionPool();
        try (Connection co = cp.setConnection()){
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
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
                                        rs.getDate("customer_dob"))
                                , new OrderLine(rs.getInt("orderLine_id"), 
                                        rs.getString("book_isbn"), 
                                        rs.getInt("order_itemQty"),
                                        rs.getFloat("order_unitPrice"), 
                                        rs.getFloat("order_taxRate"), 
                                        rs.getFloat("order_discountRate"))
                                , rs.getString("review_comment"),rs.getInt("review_rating"), rs.getDate("review_date")));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: "+ex.getMessage());
        }
    }
    
}

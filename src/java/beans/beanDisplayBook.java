
package beans;

import classes.Book;
import classes.ConnectionPool;
import classes.Publisher;
import classes.Tax;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class beanDisplayBook implements Serializable{
    
    private Book bk;

    public beanDisplayBook() {
        this.bk = new Book();
    }
    
    
    
    public Book getBook(String isbn){
        
        String query = "SELECT sb_book.*,sb_publisher.*,sb_tax.*  "
                + "FROM sb_book, sb_writer, sb_author, sb_publisher, sb_tax "
                + "WHERE sb_author.author_id = sb_writer.author_id "
                + "AND sb_book.book_isbn = sb_writer.book_isbn "
                + "AND sb_book.publisher_isbn = sb_publisher.publisher_isbn "
                + "AND sb_book.book_isbn = '"+isbn+"'";
        ConnectionPool cp = new ConnectionPool();
        try (Connection co = cp.setConnection()){
            
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                bk.setIsbn(isbn);
                bk.setPublisher(new Publisher(rs.getString("publisher_isbn"), rs.getString("publisher_name")));
                bk.setTitle(rs.getString("book_title"));
                bk.setSubtitle(rs.getString("book_subtitle"));
                bk.setDate(rs.getDate("book_date"));
                bk.setPicture(rs.getString("book_picture"));
                bk.setSummary(rs.getString("book_summary"));
                bk.setIdiom(rs.getString("book_idiom"));
                bk.setPrice(rs.getFloat("book_price"));
                bk.setTax(new Tax(rs.getInt("tax_id"), rs.getString("tax_name"), rs.getFloat("tax_rate")));
                bk.setQuantity(rs.getInt("book_quantity"));
                bk.setPages(rs.getString("book_pages"));
                bk.setPrint(rs.getString("book_print"));
                bk.setWeight(rs.getInt("book_weight"));
            }
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: "+ex.getMessage());
        }
        return bk;
    }
    
}

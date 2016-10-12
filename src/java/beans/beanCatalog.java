/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Publisher;
import classes.Tax;
import classes.Book;
import classes.ConnectionPool;
import java.io.Serializable;
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
public class beanCatalog implements Serializable {

    private HashMap<String, Book> catalog;

    public beanCatalog() {
        this.catalog = new HashMap<>();
    }

    public HashMap<String, Book> getCatalog() {
        return catalog;
    }

    public void setCatalog(HashMap<String, Book> catalog) {
        this.catalog = catalog;
    }

    public Collection<Book> getCatalogList() {
        return catalog.values();
    }

    public void fillCatalog(String input, int typeSearch) {
        ConnectionPool cp = new ConnectionPool();
        String query = "SELECT sb_book.*,sb_publisher.*,sb_tax.* "
                + "FROM sb_book, sb_writer, sb_author, sb_publisher, sb_tax, "
                + "sb_bookEvent, sb_event, sb_genre, sb_category "
                + "WHERE sb_author.author_id = sb_writer.author_id "
                + "AND sb_book.book_isbn = sb_writer.book_isbn "
                + "AND sb_book.publisher_isbn = sb_publisher.publisher_isbn ";
        
        switch(typeSearch){
            case 1:
                query+="AND sb_book.book_title LIKE '%"+input+"%'";
                break;
            case 2:
                query+="AND sb_author.author_surname LIKE '%"+input+"%'";
                break;
            case 3:
                query+="AND sb_book.book_isbn LIKE '%"+input+"%' ";
                break;
            case 4:
                query+="AND sb_bookEvent.book_isbn = sb_book.book_isbn "
                        + "AND sb_event.event_id = sb_bookEvent.event_id "
                        + "AND sb_event.event_id = "+input;
                break;
            case 5:
                query+="AND sb_author.author_id = "+input;
                break;
            case 6:
                query+="AND sb_book.book_isbn = sb_category.book_isbn "
                        + "AND sb_category.genre_name = sb_genre.genre_name "
                        + "AND sb_genre.genre_id = '"+input+"'";
                break;
        }
        //query +=  " COLLATE SQL_Latin1_General_Cp437_CI_AI";
        
        try (Connection co = cp.setConnection(); Statement stmt = co.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                catalog.put(rs.getString("book_isbn"), new Book(rs.getString("book_isbn"),
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
                        rs.getInt("book_weight")));
            }

            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: " + ex.getMessage());
        }
    }
    
    public Book getBook(String isbn){
        return catalog.get(isbn);
    }
    
}


package beans;

import classes.Book;
import classes.ConnectionPool;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;


public class beanEvents implements Serializable{
    
    private HashMap<String,Book> eventBookList;

    public beanEvents() {
        this.eventBookList = new HashMap<>();
    }
    
    public Collection<Book> getEventBookList() {
        return eventBookList.values();
    }
    
    public void fillEvents(String ref){
        String query = "SELECT * FROM sb_bookEvent WHERE event_id ="+ref;
        ConnectionPool cp = new ConnectionPool();
        
        try (Connection co = cp.setConnection()){
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            beanDisplayBook bdb = new beanDisplayBook();
            
            while(rs.next()){
                eventBookList.put(rs.getString("book_isbn"), bdb.getBook(rs.getString("book_isbn")));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: "+ex.getMessage());
        }
    }
}

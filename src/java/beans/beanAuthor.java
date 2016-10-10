
package beans;

import classes.Author;
import classes.ConnectionPool;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class beanAuthor implements Serializable{
    
    private Author aut;

    public beanAuthor() {
        this.aut = new Author();
    }
    
    public Author getAuthor(int id){
        String query ="SELECT * FROM sb_author WHERE sb_author.author_id = "+id;
        
        ConnectionPool cp = new ConnectionPool();
        try (Connection co = cp.setConnection()){
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                aut.setId(id);
                aut.setFirstname(rs.getString("author_firstname"));
                aut.setSurname(rs.getString("author_surname"));
                aut.setDob(rs.getDate("author_dob"));
                aut.setDod(rs.getDate("author_dod"));
            }
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: "+ex.getMessage());
        }
        return aut;
    }
    
}


package beans;

import classes.ConnectionPool;
import classes.Genre;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;


public class beanGenre implements Serializable{
    private HashMap<String,Genre> genres;

    public beanGenre() {
        this.genres = new HashMap<>();
    }
    
    
    
    public Collection<Genre> getGenresList(){
        return genres.values();
    }
    
    public void fillGenre(){
        String query = "SELECT * FROM sb_genre";
        ConnectionPool cp = new ConnectionPool();
        try (Connection co = cp.setConnection()){
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                genres.put(String.valueOf(rs.getInt("genre_id")), new Genre(rs.getInt("genre_id"),rs.getString("genre_name")));
            }
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: method fillGenre: "+ex.getMessage());
        }
    }
    
    public Genre getGenre(String genre){
        return genres.get(genre);
    }
    
}

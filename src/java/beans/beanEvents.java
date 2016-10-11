
package beans;

import classes.ConnectionPool;
import classes.Event;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;


public class beanEvents implements Serializable{
    
    private HashMap<String,Event> events;

    public beanEvents() {
        this.events = new HashMap<>();
    }
    
    public Collection<Event> getEventBookList() {
        return events.values();
    }
    
    public void fillEvents(){
        String query = "SELECT * FROM sb_event";
        ConnectionPool cp = new ConnectionPool();
        
        try (Connection co = cp.setConnection()){
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                events.put(String.valueOf(rs.getInt("event_id")), new Event(rs.getInt("event_id"), 
                        rs.getString("event_name"), rs.getString("event_start"),
                        rs.getString("event_end"),rs.getFloat("event_discountRate"), rs.getString("event_picture")));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: "+ex.getMessage());
        }
    }
    
    public Event getEvent(String id){
        return events.get(id);
    }
}

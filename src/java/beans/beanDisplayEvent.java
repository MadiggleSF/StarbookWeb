
package beans;

import classes.ConnectionPool;
import classes.Event;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class beanDisplayEvent implements Serializable{
    
    private Event event;

    public beanDisplayEvent() {
        this.event = new  Event();
    }
    
    public Event getEvent(int id){
        String query = "SELECT * FROM sb_event WHERE event_id = "+id;
        
        ConnectionPool cp = new ConnectionPool();
        try (Connection co = cp.setConnection()){
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                event.setId(id);
                event.setName(rs.getString("event_name"));
                event.setPicture(rs.getString("event_picture"));
                event.setStart(rs.getString("event_start"));
                event.setEnd(rs.getString("event_end"));
                event.setDiscountRate(rs.getFloat("event_discountRate"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: "+ex.getMessage());
        }
        return event;
    }
    
    
}

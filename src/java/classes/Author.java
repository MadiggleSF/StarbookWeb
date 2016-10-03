package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import javax.sql.DataSource;


/*
 ben
 */
public class Author {

    //p
    private int id;
    private String surname;
    private String firstname;
    private Date dob;
    private Date dod;

    //c
    public Author() {
    }

    public Author(int id, String surname) {
        this.id = id;
        this.surname = surname;
    }

    public Author(int id, String surname, String firstname, Date dob, Date dod) {
        this(id, surname);
        this.firstname = firstname;
        this.dob = dob;
        this.dod = dod;
    }

    //g&s
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDod() {
        return dod;
    }

    public void setDod(Date dod) {
        this.dod = dod;
    }

    //m
    public void updateAuthor(DataSource ds, String surname, String firstname, Date dob, Date dod, int id) {

        try (Connection co = ds.getConnection()){

            //String query = "UPDATE sb_author SET VALUES(?, ?, ?, ?) WHERE ID = " + id;
            String query = "UPDATE sb_author SET author_surname = ?, author_firstname = ?, "
                    + "author_dob = ?, author_dod = ? WHERE author_id = " + id;
            PreparedStatement stmt = co.prepareStatement(query);
            stmt.setString(1, surname);
            stmt.setString(2, firstname);
            stmt.setDate(3, Helpers.convertUtiltoSQLDate(dob));
            stmt.setDate(4, Helpers.convertUtiltoSQLDate(dod));
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Oops : SQL Connexion : " + ex.getMessage());
            return;
        }
    }
    
   

    public void insertAuthor(DataSource ds) {

        try (Connection co = ds.getConnection()) {

            String query = "INSERT INTO sb_author VALUES ("
                    + "?,?,?,?)";
            PreparedStatement pstmt = co.prepareStatement(query);
            pstmt.setString(1, surname);
            pstmt.setString(2, firstname);
            pstmt.setString(3,  dob.toString());
            pstmt.setString(4, dod.toString());
            pstmt.execute();
                    
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("error: sql exception: " +ex.getMessage());
        }
    }


    @Override
    public String toString() {
        return  surname + " " + firstname ;
    }

}

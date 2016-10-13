package classes;

/*
 Gab
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*; // ATTENTION A GERER LA DATE ET AJUSTER LE TYPE DATE 
import javax.sql.DataSource;
// OU DATETIME

public class Customer {

        //p
    private int id;
    private String surname;
    private String firstname;
    private String pwd;
    private String mail;
    private String cell;
    private String landline;
    private Date dob;

        // constructeur par défaut
    public Customer() {
    }

        // constructeur  avec les champs obligatoires
    public Customer(int id, String surname, String firstname, String pwd, String mail, String cell, Date dob) {
        this.id = id;
        this.surname = surname;
        this.firstname = firstname;
        this.pwd = pwd;
        this.mail = mail;
        this.cell = cell;
        this.dob = dob;
    }

        // surcharge du constructeur avec l'ajout des champs non obligatoires
        // ajout de landline
    public Customer(int id, String surname, String firstname, String pwd, String mail, String cell, String landline, Date dob) {
        this(id, surname, firstname, pwd, mail, cell, dob);
        this.landline = landline;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
       //AJOUTER CONTRAINTE DOB > 1900 
        this.dob = dob;
    }
    
    
    public String getDay(){
       String s = dob.toString();
       String []stab = s.split("-");
       
       return stab[2]; 
    }
            
    public String getMonth (){
       String s = dob.toString();
       String []stab = s.split("-");
       
       return stab[1]; 
        
    }
            
    public String getYear (){
       String s = dob.toString();
       String []stab = s.split("-");
       
       return stab[0]; 
    }
    
    //m
    @Override
    public String toString() {
        String info = firstname+" "+surname.toUpperCase()+" - Ref "+id;
        return info;
    }
    
    public void updateCustomer(DataSource ds){

        try (Connection co = ds.getConnection()){
            String query = "UPDATE sb_customer SET"
                    + "customer_surname = ?,"
                    + "customer_firstname = ?,"
                    + "customer_mail = ?,"
                    + "customer_cell = ?,"
                    + "customer_landline = ?,"
                    + "customer_dob = ?"
                    + "WHERE customer_id = ?";

            PreparedStatement pstmt = co.prepareStatement(query);
            pstmt.setString(1, "'"+surname+"'");
            pstmt.setString(2, "'"+firstname+"'");
            pstmt.setString(3, "'"+mail+"'");
            pstmt.setString(4, "'"+cell+"'");
            pstmt.setString(5, "'"+landline+"'");
            pstmt.setDate(6, Helpers.convertUtiltoSQLDate(dob));
            pstmt.setInt(7, id);

            
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("error: sql exception: " + ex.getMessage());
        }
    }
    
    public Vector getStatusList(DataSource ds){
        Vector<ItemStatus> statusList = new Vector<ItemStatus>();

        String query = "SELECT * FROM sb_customerStatus WHERE customer_id LIKE '" + id + "'";
        try (Connection co = ds.getConnection()){
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                statusList.add(new ItemStatus(rs.getInt("customer_id"),
                        rs.getInt("status_number"),
                        rs.getDate("status_date")));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + ":" + ex.getMessage());
            return statusList;
        }
        return statusList;
    }
   


}

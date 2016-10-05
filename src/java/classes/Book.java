package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;


/*
 ben
 */
public class Book {

    //p
    private String isbn;
    private Publisher publisher;
    private String title;
    private String subtitle;
    private Date date;
    private String picture;
    private String summary;
    private String idiom;
    private float price;
    private Tax tax;
    private int quantity;
    private String pages;
    private String print;
    private int weight;

    //c
    public Book() {
    }

    public Book(String isbn, String title, String subtitle, float price) {
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;

        this.price = price;
    }

    public Book(String isbn, Publisher publisher, String title, Date date, float price, Tax tax, int quantity) {
        this.isbn = isbn;
        this.publisher = publisher;
        this.title = title;
        this.date = date;
        this.price = price;
        this.tax = tax;
        this.quantity = quantity;
    }

    public Book(String isbn, Publisher publisher, String title,
            String subtitle, Date date, String picture, String summary, String idiom,
            float price, Tax tax, int quantity, String pages, String print, int weight) {
        this(isbn, publisher, title, date, price, tax, quantity);
        this.subtitle = subtitle;
        this.date = date;
        this.picture = picture;
        this.summary = summary;
        this.idiom = idiom;
        this.pages = pages;
        this.print = print;
        this.weight = weight;
    }

    //g&s
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIdiom() {
        return idiom;
    }

    public void setIdiom(String idiom) {
        this.idiom = idiom;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        if (Integer.valueOf(pages) > 0) {
            this.pages = pages;
        }
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public String getAuthor(){
        String author = "";
        ConnectionPool cp = new ConnectionPool();
        String query = "SELECT * FROM vueWriters WHERE isbn='"+isbn+"'";
        try (Connection co =  cp.setConnection()){
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                author = rs.getString("PrénomAuteur")+" "+rs.getString("NomAuteur");
            }
        } catch (SQLException ex) {
            System.err.println("Error: SQLException: "+ex.getMessage());
        }
        return author;
    }

    //m
    public float calculateInclTax() {
        float tPrice;
        tPrice = price + ((price) * (tax.getRate()) / 100);
        //troncate to xx,xx
        tPrice = ((float) ((int) (tPrice * 100))) / 100;
        return tPrice;
    }

    public String toString() {
        return title;
    }
 
/*
    public void updateBook(DataSource ds, String isbn, Publisher p, int tax_id, String title,
            String subtitle, Date publication_date, String picture, String summary,
            String idiom, Float price, int quantity, int pages, String print, int weight) {

        try (Connection co = ds.getConnection()) {
            String query = "UPDATE sb_book SET publisher_isbn = ?, tax_id = ?, "
                    + "book_title = ?, book_subtitle = ?, book_date = ?, "
                    + "book_picture = ?, book_summary = ?, book_idiom = ?, "
                    + "book_price = ?, book_quantity = ?, book_pages = ?, "
                    + "book_print = ?, book_weight = ? WHERE book_isbn = '" + isbn + "'";
            PreparedStatement stmt = co.prepareStatement(query);
            stmt.setString(1, p.getCode());
            stmt.setInt(2, tax_id);
            stmt.setString(3, title);
            stmt.setString(4, subtitle);
            stmt.setDate(5, Helpers.convertUtiltoSQLDate(publication_date));
            stmt.setString(6, picture);
            stmt.setString(7, summary);
            stmt.setString(8, idiom);
            stmt.setFloat(9, price);
            stmt.setInt(10, quantity);
            stmt.setInt(11, pages);
            stmt.setString(12, print);
            stmt.setInt(13, weight);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Oops : SQL Connexion : " + ex.getMessage());
            return;
        }
    }

    public void insertBook(DataSource ds) {

        try (Connection co = ds.getConnection()) {
            String query = "INSERT INTO sb_book VALUES ("
                    + "?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pstmt = co.prepareStatement(query);
            pstmt.setString(1, isbn);
            pstmt.setString(2, publisher.getCode());
            pstmt.setInt(3, tax.getId());
            pstmt.setString(4, title);
            pstmt.setString(5, subtitle);
            pstmt.setDate(6, (java.sql.Date) date);
            pstmt.setString(7, picture);
            pstmt.setString(8, summary);
            pstmt.setString(9, idiom);
            pstmt.setFloat(10, price);
            pstmt.setInt(11, quantity);
            pstmt.setString(12, pages);
            pstmt.setString(13, print);
            pstmt.setInt(14, weight);
            pstmt.execute();

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("error: sql exception: " + ex.getMessage());
        }
    }

    public Vector getStatusList(DataSource ds) {
        Vector<BookStatus> statusList = new Vector<BookStatus>();
        String query = "SELECT * FROM sb_bookStatus WHERE book_isbn LIKE '" + isbn + "'";
        try (Connection co = ds.getConnection()) {
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                statusList.add(new BookStatus(rs.getString("book_isbn"),
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

    public static void insertBookStatus(DataSource ds, int status_number, String book_isbn) {

        try (Connection co = ds.getConnection()) {
            String query = "INSERT INTO sb_bookStatus VALUES ("
                    + "?, ?, GETDATE())";

            PreparedStatement pstmt = co.prepareStatement(query);
            pstmt.setInt(1, status_number);
            pstmt.setString(2, book_isbn);
            pstmt.execute();
            pstmt.close();
        } catch (SQLException ex) {
            System.err.println("error: sql exception: " + ex.getMessage());
        }
    }

    public void insertBookStatus(DataSource ds, Status status) {

        try (Connection co = ds.getConnection()) {
            String query = "INSERT INTO sb_bookStatus VALUES ("
                    + "?,?,GETDATE())";

            PreparedStatement pstmt = co.prepareStatement(query);
            pstmt.setInt(1, status.getNumber());
            pstmt.setString(2, isbn);
            pstmt.execute();

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("error: sql exception: " + ex.getMessage());
        }
    }

    public void insertBookAuthor(DataSource ds, Author aut) {

        try (Connection co = ds.getConnection()) {
            String query = "INSERT INTO sb_writer VALUES ("
                    + "?,?)";

            PreparedStatement pstmt = co.prepareStatement(query);
            pstmt.setInt(1, aut.getId());
            pstmt.setString(2, isbn);
            pstmt.execute();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("error: sql exception: " + ex.getMessage());
        }
    }

    public Book returnBookFromIsbn(String isbn) {
        Book bk = null;
        ConnectionPool cp = new ConnectionPool();
        String query = "SELECT sb_book.*, sb_publisher.*,sb_tax.* "
                + "FROM sb_book, sb_writer, sb_author, sb_publisher, sb_tax "
                + "WHERE sb_book.book_isbn = ? ";
        try (Connection cnn = cp.setConnection();) {
            PreparedStatement stmt = cnn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            stmt.setString(1, isbn);
            while (rs.next()) {
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
                        rs.getInt("book_weight"));
            }

            rs.close();
            stmt.close();

            /////////////////
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bk;
        
    }
*/
}

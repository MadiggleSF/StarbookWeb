package beans;

import classes.*;
import classes.Book;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BeanCart implements Serializable {

HashMap<String, CartLine> map;
//VRAI CONSTRUCTEUR
public BeanCart() {
    this.map = new HashMap();
}

//CONSTRUCTEUR TEST
//    public BeanCart() {
//        this.map = new HashMap();
//        Book bk01 = testReturnBookFromIsbn("978-2070468508");
//        Book bk02 = testReturnBookFromIsbn("978-2211215350");
//        Book bk03 = testReturnBookFromIsbn("978-2253067078");
//        add(bk01, 3);
//        add(bk02, 1);
//        add(bk03, 2);
//        System.out.println( this.size());        
//    }
//    public HashMap<String, Item> tempFillCart() {
//        HashMap<String, Item> testFillCart = new HashMap(); 
//        Item it01 = new Item("Harry Potter", 3, 16.99f);
//        Item it02 = new Item("Le métronome", 1, 9.99f);
//        Item it03 = new Item("Brésil", 2, 12.99f);
//        testFillCart.put(it01.getTitle(), it01);
//        testFillCart.put(it02.getTitle(), it02);
//        testFillCart.put(it03.getTitle(), it03);
//        return testFillCart;
//    }
//    public Item createItem(Book bk) {
//        String isbn = bk.getIsbn();
//        String title = bk.getTitle();
//        String picture = bk.getPicture();
//        int qty = 1;
//        float unitPriceHT = bk.getPrice();
//        float totalPrice = bk.getPrice() * qty;
//        Item itemCreated = new Item(isbn, title, picture, qty, unitPriceHT);
//        return itemCreated;
//    }
//    public void create(String isbn){ 
//        create(isbn,+1);
//    }
//    
    public void create(Book bk) {
        create(bk, +1);
    }

    public void create(Book bk, int qty) {
        add(bk, qty);
    }
//    public void create(String isbn, int qty){     
//        add(isbn, qty);
//    }

//    public Item createItem(Book bk, int qty) {
//        String isbn = bk.getIsbn();
//        String title = bk.getTitle();
//        String picture = bk.getPicture();
//        float unitPrice = bk.getPrice();
//        float totalPrice = bk.getPrice() * qty;
//        Item itemCreated = new Item(isbn, title, picture, qty, unitPrice);
//        return itemCreated;
//    }
//    public void inc(String isbn){
//        add(isbn,+1);
//    }
    public void add(Book bk, int qty) {
        if (bk == null) {
            return;
        }
        if (map.containsKey(bk.getIsbn())) {
            CartLine i = map.get(bk.getIsbn());
//            b.setQty(i.getQty()+qty);
            i.change(qty);
            if (i.getQty() < 1) {
                //Si la quantité est strictement inférieure à 1, on supprime
                del(bk);
            }
        } else {
            map.put(bk.getIsbn(), new CartLine(bk, qty));
        }
    }

//    public void addTest(Book bk, int qty) {
//        if (map.containsKey(bk.getIsbn())) {
//            CartLine i = testFillCart.get(bk.getIsbn());
////            b.setQty(i.getQty()+qty);
//            i.change(qty);
//            if (i.getQty() < 1) {
//                //Si la quantité est strictement inférieure à 1, on supprime
//                del(bk);
//            }
//        } else {
//            testFillCart.put(bk.getIsbn(), new CartLine(bk, qty));
//        }
//    }
    public Book testReturnBookFromIsbn(String isbn) {
        Book bk = null;
        ConnectionPool cp = new ConnectionPool();
        String query = "SELECT sb_book.*, sb_publisher.*,sb_tax.* "
                + "FROM sb_book, sb_writer, sb_author, sb_publisher, sb_tax "
                + "WHERE sb_book.book_isbn = ? ";
        try (Connection cnn = cp.setConnection();) {
            PreparedStatement stmt = cnn.prepareStatement(query);
            stmt.setString(1, isbn);
            ResultSet rs = stmt.executeQuery();
            // stmt.execute();
            if (rs.next()) {
                bk = new Book(rs.getString("book_isbn"),
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
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bk;
    }

    public void inc(Book bk) {
        add(bk, +1);
    }
//    
//    public void add(String isbn, int qty){
//        if(map.containsKey(isbn)){
//            Item i = map.get(isbn);
////            b.setQty(i.getQty()+qty);
//            i.change(qty);
//        }else{
//            map.put(isbn, new Item(isbn, qty));
//        }
//    }
//    
//    public void dec(String isbn){
//        dec(isbn,1);
//    }

//    public void dec(Book bk) {
//        dec(bk, 1);
//    }
//    public void dec(String isbn, int qty){
//        add(isbn,-qty);
//    }
    public void dec(Book bk) {
        add(bk, -1);
    }

//    public void del(String isbn){
//        map.remove(isbn);
//    }
    public void del(Book bk) {
        map.remove(bk.getIsbn());
    }

    public Collection<CartLine> list() {
        return map.values();
    }
    
    public float calculateTotalPrice(){
       float total = 0f; 
       for(CartLine cl : list()){
           total += cl.getFinalLinePrice();
       }
       
       return total;
    }

    public int size() {
        return map.size();
    }
    
    public int quantify(){
        int i = 0;
        for(CartLine cl : list()){
            i += cl.getQty();
        }
        return i;
    }

    public void clean() {
        map.clear();
    }

    public void save() {
    }

    public void load() {

    }

    public boolean isEmpty() {
        return map.isEmpty();
    }
}

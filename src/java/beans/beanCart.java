
package beans;

import classes.*;
import classes.Book;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;


public class beanCart implements Serializable {
    
    HashMap<String, CartLine> map;

    public beanCart() {
        this.map = new HashMap();
    }
    
    
//    public HashMap<String, CartLine> tempFillCart() {
//        HashMap<String, CartLine> testFillCart = new HashMap(); 
//        CartLine it01 = new CartLine("Harry Potter", 3, 16.99f);
//        CartLine it02 = new CartLine("Le métronome", 1, 9.99f);
//        CartLine it03 = new CartLine("Brésil", 2, 12.99f);
//        testFillCart.put(it01.getTitle(), it01);
//        testFillCart.put(it02.getTitle(), it02);
//        testFillCart.put(it03.getTitle(), it03);
//        return testFillCart;
//    }
    
//    public CartLine createItem(Book bk) {
//        String isbn = bk.getIsbn();
//        String title = bk.getTitle();
//        String picture = bk.getPicture();
//        int qty = 1;
//        float unitPriceHT = bk.getPrice();
//        float totalPrice = bk.getPrice() * qty;
//        CartLine itemCreated = new CartLine(isbn, title, picture, qty, unitPriceHT);
//        return itemCreated;
//    }
    
    public void create(String isbn){ 
        create(isbn,+1);
    }
    
    public void create(String isbn, int qty){     
        add(isbn, qty);
    }
    
//    public CartLine createItem(Book bk, int qty) {
//        String isbn = bk.getIsbn();
//        String title = bk.getTitle();
//        String picture = bk.getPicture();
//        float unitPrice = bk.getPrice();
//        float totalPrice = bk.getPrice() * qty;
//        CartLine itemCreated = new CartLine(isbn, title, picture, qty, unitPrice);
//        return itemCreated;
//    }
    
    public void inc(String isbn){
        add(isbn,+1);
    }
    
    public void inc (Book bk) {
        add(bk.getIsbn());
        
        
    }
    public void add(Book bk, int qty){
        if(map.containsKey(bk.getIsbn())){
            CartLine i = map.get(bk.getIsbn());
//            b.setQty(i.getQty()+qty);
            i.change(qty);
        }else{
            map.put(bk.getIsbn(), new CartLine(bk, qty));
        }
    }
    
    public void add(String isbn, int qty){
        if(map.containsKey(isbn)){
            CartLine i = map.get(isbn);
//            b.setQty(i.getQty()+qty);
            i.change(qty);
        }else{
            map.put(isbn, new CartLine(isbn, qty));
        }
    }
    
    public void dec(String isbn){
        dec(isbn,1);
    }
    
    public void dec(String isbn, int qty){
        add(isbn,-qty);
    }
       
    public void del(String isbn){
        map.remove(isbn);
    }
    
    public Collection<CartLine> list(){
        return map.values();
    }
    
    public int size(){
        return map.size();
    }
            
    public void clean(){
        map.clear();
    }
    
    public void save(){       
    }
    
    public void load(){
        
    }
   
    public boolean isEmpty(){
        return map.isEmpty();
    }
}

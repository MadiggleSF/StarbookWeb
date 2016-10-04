
package beans;

import classes.*;
import classes.Book;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;


public class beanCart implements Serializable {
    
    HashMap<String, Item> map;

    public beanCart() {
        this.map = new HashMap();
    }
    
    
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
    
    public void create(String isbn){ 
        create(isbn,+1);
    }
    
    public void create(String isbn, int qty){     
        add(isbn, qty);
    }
    
//    public Item createItem(Book bk, int qty) {
//        String isbn = bk.getIsbn();
//        String title = bk.getTitle();
//        String picture = bk.getPicture();
//        float unitPrice = bk.getPrice();
//        float totalPrice = bk.getPrice() * qty;
//        Item itemCreated = new Item(isbn, title, picture, qty, unitPrice);
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
            Item i = map.get(bk.getIsbn());
//            b.setQty(i.getQty()+qty);
            i.change(qty);
        }else{
            map.put(bk.getIsbn(), new Item(bk, qty));
        }
    }
    
    public void add(String isbn, int qty){
        if(map.containsKey(isbn)){
            Item i = map.get(isbn);
//            b.setQty(i.getQty()+qty);
            i.change(qty);
        }else{
            map.put(isbn, new Item(isbn, qty));
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
    
    public Collection<Item> list(){
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

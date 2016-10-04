
package beans;

import classes.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;


public class beanCart implements Serializable {
    
    HashMap<String, Item> map;

    public beanCart() {
        this.map = new HashMap();
    }
    
    
    
    public void create(String ref){ 
        create(ref,+1);
    }
    
    public void create(String ref, int qty){     
        add(ref, qty);
    }
    
    public void inc(String ref){
        add(ref,+1);
    }
    
    public void add(String ref, int qty){
        if(map.containsKey(ref)){
            Item i = map.get(ref);
//            i.setQty(i.getQty()+qty);
            i.change(qty);
        }else{
            map.put(ref, new Item(ref, qty));
        }
    }
    
    public void dec(String ref){
        dec(ref,1);
    }
    
    public void dec(String ref, int qty){
        add(ref,-qty);
    }
       
    public void del(String ref){
        map.remove(ref);
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

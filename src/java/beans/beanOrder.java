
package beans;

import classes.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


public class beanOrder implements Serializable {
    
    Collection<CartLine> col = new ArrayList<>();
    ConnectionPool cp = new ConnectionPool();
        
    public Collection<CartLine> getCol(){
        return col;
    }
    
    public void setCol(Collection<CartLine> col){
        this.col = col;
    }
    
    public void add(CartLine c){
        if(!col.isEmpty()){
            for(CartLine i : col){
                if(i.getIsbn().equals(c.getIsbn())){
                    c.setQty(c.getQty()+i.getQty());
                    col.remove(i);
                    break;
                }                
            }
        }
        col.add(c);
    }
    
    public float getFinalPrice(){
        float p = 0f;
        for(CartLine i : col){
           p += i.getFinalLinePrice();
        }
        return p;
    }
    
    public int size(){
        return col.size();
    }
}

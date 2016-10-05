package beans;

import classes.*;
import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class beanOrder implements Serializable {

    private HashMap<String, CartLine> map;
    ConnectionPool cp = new ConnectionPool();

    public void add(CartLine c) {
        if(map.containsKey(c.getIsbn())){
            c.setQty(c.getQty() + (map.get(c.getIsbn()).getQty()));
        }
        map.put(c.getIsbn(), c);
    }

    public float price() {
        float p = 0f;
        if (map != null) {
            for (CartLine c : (Collection<CartLine>) list()) {
                p += c.getLinePrice();
            }
        }
        return p;
    }

    public float priceTax() {
        float p = 0f;
        if (map != null) {
            for (CartLine c : (Collection<CartLine>) list()) {
                p += c.getLineTaxedPrice();
            }
        }
        return p;
    }

    public float priceTaxDiscount() {
        float p = 0f;
        if (map != null) {
            for (CartLine c : (Collection<CartLine>) list()) {
                p += c.getFinalLinePrice();
            }
        }
        return p;
    }

    public float priceTaxDiscountShipping() {
        float p = priceTaxDiscount();
        return p;
    }

    public Collection list() {
        return map.values();
    }

    public void saveOrder() {
        try (Connection cnn = cp.setConnection();) {
            String query = "";

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

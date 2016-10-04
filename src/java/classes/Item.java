
package classes;


public class Item {
    
    
    private String ref;
    private int qty;
    private float unitPrice;
    private float totalPrice;

    public Item(String ref, int qty, float unitPrice) {
        this.ref = ref;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = unitPrice * qty;
    }
    
    public void change(int qty){
        this.qty += qty;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public float getTotalPrice() {
        return totalPrice = unitPrice * qty;
    }  
}


package classes;


public class Item {
    private Book bk;
//    private String isbn;
//    private String title;
//    private String picture;
    private int qty;
//    private float unitPrice;
//    private float totalPrice;

    public Item(Book bk, int qty) {
        this.bk = bk;
        this.qty = qty;
    }

//    public DisplayableItem displayItem(String isbn, String title, String picture, int qty, float unitPrice) {
//        this.isbn = isbn;
//        this.title = title;
//        this.picture = picture;
//        this.qty = qty;
//        this.unitPrice = unitPrice;
//        this.totalPrice = unitPrice * qty;
//    }

    
    
//    public Item getItem() {
//        ConnectionPool cp = new ConnectionPool();
//            
//    try (Connection cnn = cp.setConnection();) {
//    String query = "";
//
//    /////////////////
//
//    } catch (SQLException ex) {
//        Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    return 
//            }
    
    public void change(int qty){
        this.qty += qty;
    }

    public Book getBk() {
        return bk;
    }

    public void setBk(Book bk) {
        this.bk = bk;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

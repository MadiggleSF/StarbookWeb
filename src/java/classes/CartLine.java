package classes;

import java.util.Date;

/**
 * ************************************************
 * EN CHANTIER *
*************************************************
 */
public class CartLine {

    private Book bk;
    private int qty;
    private float discountRate;
    //discountRate 0.00 = 0% -> 1.00 = 100% de réduc

    public CartLine(Book bk, int qty) {
        this.bk = bk;
        this.qty = qty;
        this.discountRate = 0f;
    }


    public void change(int qty) {
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

    public float getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(float discountRate) {
        this.discountRate = discountRate;
    }

    //getters du book
    public String getIsbn() {
        return bk.getIsbn();
    }

    public Publisher getPublisher() {
        return bk.getPublisher();
    }

    public String getTitle() {
        return bk.getTitle();
    }

    public String getSubtitle() {
        return bk.getSubtitle();
    }

    public Date getDate() {
        return bk.getDate();
    }

    public String getPicture() {
        return bk.getPicture();
    }

    public String getSummary() {
        return bk.getSummary();
    }

    public String getIdiom() {
        return bk.getIdiom();
    }

    public float getBookPrice() {
        return bk.getPrice();
    }

    public Tax getTax() {
        return bk.getTax();
    }

    public int getStock() {
        return bk.getQuantity();
    }

    public String getPages() {
        return bk.getPages();
    }

    public String getPrint() {
        return bk.getPrint();
    }

    public int getWeight() {
        return bk.getWeight();
    }

    //m
    public float getBookTaxedPrice() {
        float uPrice;
        uPrice = getBookPrice() + ((getBookPrice() * (getTax().getRate())) / 100);
        uPrice = ((float) ((int) (uPrice * 100))) / 100;
        return uPrice;
    }

    public float getLinePrice() {
        float lPrice;
        lPrice = qty * getBookPrice();
        lPrice = ((float) ((int) (lPrice * 100))) / 100;
        return lPrice;
    }

    public float getLineTaxedPrice() {
        float lPrice;
        lPrice = qty * getBookTaxedPrice();
        //troncate to xx,xx
        lPrice = ((float) ((int) (lPrice * 100))) / 100;
        return lPrice;
    }

    public float getFinalLinePrice() {
        float lPrice;
        lPrice = getLineTaxedPrice() - (getLineTaxedPrice() * discountRate);
        lPrice = ((float) ((int) (lPrice * 100))) / 100;
        return lPrice;
    }
    
    @Override
    //pour les tests (changement possible)
    public String toString(){
        String inf = getTitle() + " " + getFinalLinePrice()+ "€";
        return inf;
    }

}

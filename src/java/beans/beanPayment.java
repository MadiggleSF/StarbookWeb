package beans;

import java.io.Serializable;
import java.util.Date;

public class beanPayment implements Serializable {
    
    private String ccOwner;
    private String ccNumber;
    private String ccCrypto;
    private Date ccExp;

    
    public beanPayment(String ccOwner, String ccNumber, String ccCrypto) {
        this.ccOwner = ccOwner;
        this.ccNumber = ccNumber;
        this.ccCrypto = ccCrypto;
    }
    
    


    public boolean checkCC() {
        if (checkCCNumber() && checkCCCrypto()) {
            return true;
        }
        return false;
    }

    public boolean checkCCNumber() {
        ccNumber = ccNumber.replaceAll(" ", "");
        ccNumber = ccNumber.replaceAll("-", "");
        if (ccNumber.matches("[0-9]{16}")) {
            return true;
        }
        return false;
    }

    

    public boolean checkCCCrypto() {
        if (ccCrypto.matches("[0-9]{3}")) {
            return true;
        }
        return false;
    }

}

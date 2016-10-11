package beans;

import java.beans.*;
import java.io.Serializable;

public class beanPayment implements Serializable {
    
    
    public boolean checkCC(int ccNumber, int crypto, String expM, String expY){
        if(checkCCNumber(ccNumber) && checkCCCrypto(crypto) && checkCCDate(expM, expY)){
            return true;
        }
        return false;
    }

    public boolean checkCCNumber(int ccNumber) {
        if(){
            return true;
        }
        return false;
    }
    
    public boolean checkCCDate(String expM, String expY){
        int m = Integer.valueOf(expM);
        int y = Integer.valueOf(expY);
        
        if((m > 0 && m <= 12) && (y >= 2016 && y <= 2025)){
            return true;
        }
        return false;
    }
    
    public boolean checkCCCrypto(int cryto){
        return false;
    }

}

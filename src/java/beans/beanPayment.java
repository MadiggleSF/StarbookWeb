package beans;

import java.io.Serializable;
import java.util.HashMap;

public class beanPayment implements Serializable {
    
    HashMap<String, String> infos;

    
    public beanPayment(String ccOwner, String ccNumber, String expM, String expY, String crypto) {
        infos = new HashMap<>();
        infos.put("ccOwner", ccOwner);
        infos.put("ccNumber", ccNumber);
        infos.put("ccExpM", expM);
        infos.put("ccExpY", expY);
        infos.put("ccCrypto",crypto);
    }
    
    


    public boolean checkCC() {
        if (checkCCNumber() && checkCCCrypto() && checkCCDate()) {
            return true;
        }
        return false;
    }

    public boolean checkCCNumber() {
        infos.put("ccNumber", (infos.get("ccNumber").replaceAll(" ", "")));
        infos.put("ccNumber", (infos.get("ccNumber").replaceAll("-", "")));
        if (infos.get("ccNumber").matches("[0-9]{16}")) {
            return true;
        }
        return false;
    }

    public boolean checkCCDate() {
        if ((infos.get("ccExpM").matches("(0[1-9]|1[012])")) && (infos.get("ccExpY").matches("(0[2]|1[0]|2[12]|3[0-9])"))) {
            if (Integer.valueOf(infos.get("ccExpY") + infos.get("ccExpM")) > 201610 && Integer.valueOf(infos.get("ccExpY") + infos.get("ccExpM")) <= 202501) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCCCrypto() {
        if (infos.get("ccCrypto").matches("[0-9]{3}")) {
            return true;
        }
        return false;
    }

}

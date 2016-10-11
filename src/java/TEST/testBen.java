/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import java.util.Date;

/**
 *
 * @author cdi313
 */
public class testBen {
    
    
    public static boolean checkCCNumber(String ccNumber) {
        ccNumber = ccNumber.replaceAll(" ", "");
        ccNumber = ccNumber.replaceAll("-","");
        if(ccNumber.matches("[0-9]{16}")){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        String t = "06878721   76719    757";
        System.out.println(t.length());
        System.out.println(t);
        System.out.println(checkCCNumber(t));
        
    }
    
}

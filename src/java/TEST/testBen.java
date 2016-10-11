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
    
    public static boolean checkCCDate(String expM, String expY){
        
        int m = Integer.valueOf(expM);
        int y = Integer.valueOf(expY);
        
        
        if((m > 0 && m <= 12) && (y >= 2016 && y <= 2025)){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        String m = "-1";
        String y = "2018";
        boolean test = checkCCDate(m, y);
        System.out.println(test);
        
        System.out.println(Integer.valueOf("mm"));
        
    }
    
}

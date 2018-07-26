/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation_hotel;

import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author alimh
 */
public class credit extends payment{
    public String username ; 
    public String password;
    
   
    @Override
    public boolean pay() throws SQLException {
        super.pay(); //To change body of generated methods, choose Tools | Templates.
        HashMap map = new HashMap();
        int payment_id = this.id ; 
       
        map.put("paymentId",payment_id);
        map.put("username", username);
        map.put("pass", password);
        
        if(this.db.insert("credit", map))
            return true;
        return false;
    }
   
    
    /*
    @Override
    public boolean cancel_pay(int id) throws SQLException {
      super.cancel_pay(id); //To change body of generated methods, choose Tools | Templates.
      
    }

    */

}

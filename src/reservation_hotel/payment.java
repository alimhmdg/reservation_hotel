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
public class payment {
    public database  db= database.get_instance();
    public int id ;
    public int user_id;
    public float cost;
    public String date;
    
    public boolean pay() throws SQLException{
       HashMap map  = new HashMap();
       map.put("id", id);
       map.put("userId", user_id);
       map.put("cost", cost);
       map.put("Timing", date);
       if(db.insert("payment", map))
           return true;
       return false;
    }
    public boolean cancel_pay(int id) throws SQLException{
       if(db.delete("payment", id))
           return true;
       return false;
    }
}

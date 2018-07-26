/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation_hotel;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author alimh
 */
public class feedback {
    int id ;
    public String Content ; 
    public String time;
    public int user_id ;
    
    public database db = database.get_instance();
    public boolean add_feedback() throws SQLException{
        HashMap data = new HashMap();
        data.put("content",this.Content );
        data.put("Timing",this.time);
        data.put("userId",""+this.user_id);
        if(! db.insert("feedback", data)){
            return true;
        }
        return false;
    }
    
    public boolean delete_feedback(int id) throws SQLException{
        if(db.delete("feedback", id)){
            return true;
        }
        return false;
    }
    
    public ArrayList view_feedback() throws SQLException{
        ResultSet result = db.select("feedback",null);
        ArrayList<feedback> list =new ArrayList<feedback>();
 
        if( result != null){
            while(result.next()){
                String content = result.getString("content");
                String time = result.getString("Timing");  
                int id = result.getInt("id");
                feedback fb = new feedback();
                fb.Content = content;
                fb.time = time;
                fb.id = id; 
                list.add(fb);
            }
            return list;
        }
        return null;
    }
    
}

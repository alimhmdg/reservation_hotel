/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation_hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author alimh
 */
public class booking_manger {
    database db = database.get_instance();
    public int id;
    public  String start_date;
    public  int num_days;
    public int user_id ; 
    public int room_id; 
    public int payment_id;
    public String board_option;
    public int room_num;
    
    
    public boolean add_booking() throws SQLException{
        HashMap data = new HashMap();
        data.put("userId" , this.user_id);
        data.put("roomId",this.room_id);
        data.put("start_date",this.start_date);
        data.put("num_days",this.num_days);
        data.put("paymentId",this.payment_id);
        data.put("boardOption",this.board_option);
        data.put("room_num",this.room_num);
        if(db.insert("booking", data))
            return true;
        return false;
    }
    public boolean delete_booking(int id ) throws SQLException{
        if(db.delete("booking", id))
            return true;
        return false;
    }
    public boolean update_booking(int id) throws SQLException{
        
        HashMap data = new HashMap();
        data.put("userId" , this.user_id);
        data.put("roomId",this.room_id);
        data.put("start_date",this.start_date);
        data.put("num_days",this.num_days);
        data.put("paymentId",this.payment_id);
        data.put("boardOption",this.board_option);
        if(db.update("booking", data, id) != 0 )
            return true;
        return false;
    }
    public ArrayList<booking_manger> get_booking() throws SQLException{
            ResultSet result = db.select("booking",null);
        ArrayList<booking_manger> list =new ArrayList<booking_manger>();

                if( result != null){
            while(result.next()){
                int userId = result.getInt("userId");
                int roomId = result.getInt("roomId");
                String start_date = result.getString("start_date");
                int num_days = result.getInt("num_days");
                int id = result.getInt("id");
                int paymentId = result.getInt("paymentId");
                String boardoption = result.getString("boardOption"); 
                int room_num = result.getInt("room_num"); 
                booking_manger c = new booking_manger();
                c.id = id;
                c.num_days = num_days;
                c.payment_id = paymentId;
                c.room_id = roomId;
                c.start_date = start_date;
                c.user_id = userId;
                c.board_option = boardoption;
                list.add(c);
            }
            return list;
        }
    
        return null;
    
    }
}

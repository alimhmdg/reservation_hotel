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
public class customer extends user{
    database db =database.get_instance();
    public boolean add_customer() throws SQLException{
        HashMap map = new HashMap();
       // map.put("typeUser", this.type);
        //int type_id  = db.select("usertype",map).getInt("id");
        int type_id = 2;
        HashMap data = new HashMap();
        data.put("name",this.name);
        data.put("email",this.mail);
        data.put("username",this.user_name);
        data.put("pass",this.pass);
        data.put("telephone",this.telephone);
        data.put("ssn",this.ssn);
        data.put("userTypeId",type_id);
        
        if(! db.insert("users", data)){
            //System.out.println("insert  user");
            return true;
        }
        return false;
    }
    
    public ArrayList<room> search_rooms(String room_type, int statue) throws SQLException{
        room r =new room();
        return r.get_rooms(room_type , statue);
    }
    
    public boolean addbooking(int room_id,String start_date , int num_days , String board_option , int user_id , int payment_id  , int room_num) throws SQLException{
        
        this.bm.user_id = user_id;
        this.bm.num_days =num_days;
        this.bm.start_date = start_date;
        this.bm.payment_id = payment_id;
        this.bm.room_id = room_id;
        this.bm.board_option = board_option;
        this.bm.room_num = room_num;
        if(! this.bm.add_booking()){
            return true;
        }
        return false;
    }
    public boolean delete_booking(int id) throws SQLException{
        if(this.bm.delete_booking(id)){
            return true;
        }
        return false;
    }
    public boolean update_booking(int room_id,String start_date , int num_days , String board_option , int user_id , int payment_id , int id , int room_number) throws SQLException{
        this.bm.user_id = user_id;
        this.bm.num_days = num_days;
        this.bm.start_date = start_date;
        this.bm.payment_id = payment_id;
        this.bm.room_id = room_id;
        this.bm.board_option = board_option;
        this.bm.room_num = room_number;
        if(this.bm.update_booking(id)){
            return true;
        }
        return false;
    }
    
    
    public boolean delete_customer(int id) throws SQLException{
        if(db.delete("users", id)){
            return true;
        }
        return false;        
    }
    
    public boolean update_customer(int id) throws SQLException{
        
        HashMap data = new HashMap();
        data.put("name",this.name);
        data.put("email",this.mail);
        data.put("username",this.user_name);
        data.put("pass",this.pass);
        data.put("telephone",this.telephone);
        data.put("ssn",this.ssn);
        data.put("userTypeId",this.type_id);
        
        if(db.update("users", data, id) != 0){
            return true;
        }
        return false;
    }
    
    public ArrayList<customer> get_customers() throws SQLException{
        ResultSet result = db.select("users",null);
        ArrayList<customer> list =new ArrayList<customer>();

                if( result != null){
            while(result.next()){
                String name = result.getString("name");
                String username = result.getString("username");
                String pass = result.getString("pass");
                String mail = result.getString("email");
                int id = result.getInt("id");
                int tele = result.getInt("telephone");
                int type_id = result.getInt("userTypeId");
                int ssn = result.getInt("ssn");
                
                customer c = new customer();
                list.add(c);
            }
            return list;
        }
    
        return null;
    }
    
    public boolean give_feedback(String content  , String date) throws SQLException{
        feedback fb = new feedback();
        fb.Content = content;
        fb.time = date ; 
        fb.user_id = this.id;
        if(fb.add_feedback()){
            return true;
        }
        return false;
    }
   
    public boolean pay(payment p) throws SQLException{
       if(! p.pay()){
           return true;
       }
       return false;        
    }
    
    public boolean pay_with_credit(credit c) throws SQLException{
        if(! c.pay()){
            return true;
        }
        return false;
    }
    
    public ArrayList<booking_manger> view_booking() throws SQLException{
        ArrayList<booking_manger> list =  bm.get_booking();
        
        ArrayList<booking_manger> list2 = new ArrayList<booking_manger>();
        for(int k = 0 ; k < list.size() ; k++){
            if(list.get(k).user_id == this.id){
                System.out.println(list.get(k).id);
                list2.add(list.get(k));
            }
        }
        return list2;
    }
}

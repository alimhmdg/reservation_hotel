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
public class admin extends user{
    public database db = database.get_instance();
    public booking_manger b_manger =new booking_manger();
    
    public ArrayList<feedback> view_feedback() throws SQLException{
        feedback fb =new feedback();
        ArrayList <feedback> list = fb.view_feedback();
        if(list != null){
            return list;
        }
        return null;
    }
    
    public boolean delete_feedback(int id ) throws SQLException{
    
        feedback fb =new feedback();
        if(fb.delete_feedback(id)){
            return true;
        }
        return false;
    }
    public boolean add_customer(customer c) throws SQLException{
        if(c.add_customer())
            return true;
        return false;
    }
    
    public boolean update_customer(customer c , int id) throws SQLException{
        if(c.update_customer(id))
            return true;
        return false;
    }
    public boolean delete_customer(customer c , int id) throws SQLException{
        if(c.delete_customer(id))
            return true;
        return false;
    }
    public ArrayList<customer> view_customers () throws SQLException{
        customer c = new customer();
        return c.get_customers();
    }
    
    public boolean  add_room (String type , int room_num) throws SQLException{
        room r = new room();
        r.room_num = room_num;
        r.type = type;
        
        if(r.add_room()){
            return true;
        }
        return false;
    }
    public boolean delete_room (int id) throws SQLException{
        room r = new room();
            if(r.delete_room(id))
                return true;
             return false;
    }
    /*public boolean update_room (int id , int room_num , String type){
        room r = new room(); 
    }*/
    
/*    public ArrayList<room> view_room() throws SQLException{
        room r = new room();
        ArrayList<room> list = r.get_rooms();
        if(list != null)
            return list;
        return null;
    }
  */  
}

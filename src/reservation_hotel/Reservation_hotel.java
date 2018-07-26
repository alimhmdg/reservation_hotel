/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation_hotel;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import gui.login;
import gui.pay;
import gui.update_booking;
import java.util.ArrayList;
/**
 *
 * @author alimh
 */
public class Reservation_hotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
  //      java.util.Date date =new java.util.Date();
//        feedback fb =new feedback();
    //    fb.Content = "wonder <3 <2 ";
      //  fb.user_id = 3;
        //fb.time = date.toString();
       login lg = new login();
     // update_booking b =new update_booking(new customer());
      /*
        room r  ; 
        customer cs =new customer ();
        String room_type = "single"; 
     ArrayList<room> rooms = cs.search_rooms(room_type , 0);
     r = rooms.get(0);
        */
        
       
    //   pay p =new pay();
       
       
// fb.add_feedback();
        //fb.delete_feedback(1);
        //fb.view_feedback();
    // user  u = new user();
  //   System.out.println(u.login("aa@yahoo.com", "12345"));
  // main_frame mf =new main_frame();
  // mf.Login();
  // mf.setVisible(true);
// TODO code application logic here
       //database db=database.get_instance();
       //HashMap<String,String> input= new HashMap<String,String>();

       //input.put("name", "llllllllllll");     
       //input.put("id","1");     
      
       
       //db.delete("mytable", 10);
       //int x = db.update("mytable", input, 5);
       //db.insert("mytable", input);     
       //System.out.println(x);

       /* ResultSet rs = db.select("mytable" , input);
       if(rs !=null){
           int name;
           
           while(rs.next())
           {
               name = rs.getInt("id");
               System.out.println(name);
           }
           rs.close();
           
       }
       else {
           System.out.println("no select");
       }
       

  /*     String name = "ali,";
       name= name.substring(0, name.length()-1);
       System.out.println(name);
    */   
      
    }
    
}

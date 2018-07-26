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
public class room {
    public int id;
    public String type ;
    public int room_num;
    public int statue;
    database db = database.get_instance();
    public boolean add_room() throws SQLException{
          HashMap data = new HashMap();
        data.put("roomType",type );
        data.put("roomNum",room_num);
        data.put("statue",statue);
        if(! db.insert("room", data)){
            return true;
        }
        return false;
    }
    
    public boolean update_room(int id) throws SQLException{
          HashMap data = new HashMap();
          data.put("roomType",type );
          data.put("roomNum",room_num);
        data.put("statue",statue);
        if(db.update("room", data, id) !=0){
            return true;
        }
        return false;
    }
    
    public boolean delete_room(int id) throws SQLException{
        if(db.delete("room", id)){
            return true;
        }
        return false;
    }
    
    public ArrayList<room> get_rooms(String room_type , int statue) throws SQLException{
        HashMap map = new HashMap();
        map.put("roomType", room_type);
        map.put("statue", statue+"");
        ResultSet result = db.select("room",map);
        ArrayList<room> list =new ArrayList<room>();
 
        if( result != null){
            while(result.next()){
                int room_num = result.getInt("roomNum");
                String type = result.getString("roomType");  
                int id = result.getInt("id");
                int statu =result.getInt("statue");
                room m = new room();
                m.room_num = room_num;
                m.type = type;
                m.id = id;
                m.statue = statu;
                list.add(m);
            }
            return list;
        }
    
        return null;
    }
     
}

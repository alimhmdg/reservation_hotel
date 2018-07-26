/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation_hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author alimh
 */
public class user {
    public int id ;
    public String name ; 
    public String user_name ; 
    public String mail;
    public String pass;
    public int ssn ;
    public int telephone;
    public String type;
    public int type_id;
    public booking_manger bm = new booking_manger();
    public database db = database.get_instance();
    
    public int login(String mail , String password) throws SQLException{
        
        HashMap map = new HashMap();
        map.put("email", mail);
        map.put("pass", password);
        ResultSet result = db.select("users", map);
        if (result!= null){
            while(result.next()){
                int type = result.getInt("userTypeId");
                this.type_id = type;
                this.id = result.getInt("id");
                this.mail = result.getString("email");
                this.name = result.getString("name");
                this.pass = result.getString("pass");
                this.ssn = result.getInt("ssn");
                this.user_name = result.getString("username");
                
                return type;
            }
            
        }
        return 0 ;
    }
}

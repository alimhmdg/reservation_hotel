/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation_hotel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author alimh
 */
public class database {
   
    private database(){
        this.connect();
    }
    
    private static database instance;
    private String host="jdbc:mysql://localhost:3306/reservation";
    private String user="root";
    private String pass="";
    private Connection conn;
    private Statement stmt;
    private String SQl;
    
    
    public static database get_instance(){
        if (instance == null)
            instance = new database();
        
        return instance;    
    }
    
    private void connect ()
    {
      try{
        Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){
            System.out.println("error" + e);    
        }
        try{
        conn=java.sql.DriverManager.getConnection(host, user, pass);
        }
        catch(SQLException e){ 
            System.out.println("error" + e);
        }
         
    }
    
    public boolean insert(String table , HashMap data) throws SQLException{
        
        String records = "" ;
        String values = "" ; 
        
        for (Object record : data.keySet())
        {
            records += (String)record+",";
            values +="'"+data.get(record)+"',";
        }
        values = values.substring(0,values.length()-1);
        records = records.substring(0,records.length()-1);
        String query = "INSERT INTO " + table + "(" +records +") VALUES ("+values +")" ;    
        System.out.println(query);
        this.stmt = conn.createStatement();
        return this.stmt.execute(query);
    }    
    
    public boolean delete (String table ,int id) throws SQLException{
        String query = "DELETE FROM " + table + " WHERE id ="+id;
        this.stmt = conn.createStatement();
        return this.stmt.execute(query);
    }
    
    
    public int update (String table , HashMap data , int id ) throws SQLException{
        
        String set= "" ; 
        for (Object record : data.keySet())
        {
            set += (String)record +"='"+data.get(record)+"',"; 
        }
        set = set.substring(0, set.length()-1);
        System.out.println(set);
        String query = "UPDATE "+table+" SET "+set+" WHERE id="+id;
        System.out.println(query);
        
        this.stmt = conn.createStatement();
        return this.stmt.executeUpdate(query);
    }
    public ResultSet select (String table , int id) throws SQLException{
        String query = "SELECT * FROM "+ table+" where id="+id;
        this.stmt = conn.createStatement();
        ResultSet rs =this.stmt.executeQuery(query);
        return rs;
        
    }
    
    public ResultSet select (String table , HashMap where) throws SQLException{
        String where_line = "";
        if(where !=null)
        {   
            for (Object record : where.keySet())
                where_line +=(String)record+"='"+(String)where.get(record) +"' AND ";
            
            where_line = where_line.substring(0, where_line.length()-4);
            where_line = "WHERE "+ where_line ;   
        }
        String query = "SELECT * FROM "+ table+" "+ where_line;
     //   System.out.println(query);
        this.stmt = conn.createStatement();
        ResultSet rs =this.stmt.executeQuery(query);
        return rs;
    }
    
    
    ////////
    /*public ResultSet select(String table , ArrayList records ,HashMap where) throws SQLException{
        String records_line = "";
        String where_line = "";
        for(int k =0 ; k<records.size() ; k++)
            records_line += records.get(k)+",";
        records_line = records_line.substring(0, records_line.length()-1);
        
        if(where !=null)
        {   
            for (Object record : where.keySet())
                where_line +=(String)record+"="+(String)where.get(record) +",";
            
            where_line = where_line.substring(0, where_line.length()-1);
            where_line = "WHERE "+ where_line ;   
        }
        
        String query = "SELECT" +records_line + " FROM "+table+" "+where_line;
        this.stmt = conn.createStatement();
        ResultSet rs =this.stmt.executeQuery(query);
        return rs;
    }
    
    public ResultSet select(String table , ArrayList records ,int id) throws SQLException{
        
        String records_line = "";
        for(int k =0 ; k<records.size() ; k++)
            records_line += records.get(k)+",";
        records_line = records_line.substring(0, records_line.length()-1);
        
        
        String query = "SELECT" +records_line + " FROM "+table+" where id="+id;
        this.stmt = conn.createStatement();
        ResultSet rs =this.stmt.executeQuery(query);
        return rs;
    }
    
    */
    public boolean close(){
        try{
        this.conn.close();
        return true;
        }
        catch(SQLException e){
        return false;
        }
    }
    
}
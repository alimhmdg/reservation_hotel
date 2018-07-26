/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import reservation_hotel.credit;
import reservation_hotel.customer;
import reservation_hotel.payment;
import reservation_hotel.room;

/**
 *
 * @author alimh
 */
public class pay {
    private room r;
    private JFrame frame;
    private JButton credit;
    private JLabel username;
    private JLabel password;
    private JTextField t_username;
    private JTextField t_password;
    private JButton pay , Bk ,Exit;
    private JLabel cost; 
    private JLabel room_num; 
    public pay(customer cs , String meal_flan , String start_date , int num_of_days ,String room_type ) {
       
        try{
     ArrayList<room> rooms = cs.search_rooms(room_type , 0);
     r = rooms.get(0);
        }
        catch(SQLException ex){
                 System.out.println("cant  search empty rooms ");
        }
     frame =  new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,400);
        frame.setResizable(false);
        frame.setTitle("payment");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
     credit = new JButton("credit");
     Exit = new JButton("Exit");
     Bk = new JButton("back");
     pay = new JButton("pay");
     username = new JLabel("username");
     password = new JLabel("password");
     t_username = new JTextField();
     t_password = new JTextField();
     room_num = new JLabel();
     room_num.setBounds(200,250 ,50 ,30 );
     frame.add(room_num);
     room_num.setText(r.room_num +" ");
     credit.setBounds(175,30,100,30);
     frame.add(credit);
     frame.add(Exit);
     frame.add(Bk);
     frame.add(pay);
     
     cost = new JLabel();
     cost.setBounds(100,250,100,30);
     frame.add(cost);
     
     int x= num_of_days *50;
     
     cost.setText(x+"  $$");
     
     pay.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   if(t_username.getText() != null || t_password.getText() !=null)
                   {
                       credit cre = new credit();
                       cre.date = new Date().toString();
                       cre.cost = num_of_days * 50;
                       cre.user_id = cs.id;
                       cre.username = username.getText();
                       cre.password = password.getText();
                       try {
                           if(cs.addbooking(r.id, start_date, num_of_days, meal_flan, cs.id, 0 , r.room_num)){
                               
                               if(cs.pay_with_credit(cre)){
                                   r.statue = 1;
                                   r.update_room(r.id);
                                   frame.dispose();
                                   customer_controller cc  =new customer_controller(cs);
                               }
                               else{
                                   System.out.println("cant insert credit data");
                               }
                           }
                           else{
                                   System.out.println("cant insert Booking data");
                               }
                       }
                       catch (SQLException ex) {
                       System.out.println("SQL Error Occured");
                       }
                   }
                   else{
                       payment p = new payment();
                       p.date = new Date().toString();
                       p.cost = num_of_days * 50 ; 
                       p.user_id = cs.id;                       
                       
                       try {
                           if(cs.addbooking(r.id, start_date, num_of_days, meal_flan, cs.id, 0 , r.room_num)){
                               if(cs.pay(p)){
                                   r.statue = 1;
                                   r.update_room(r.id);
                                               
                                   frame.dispose();
                                   customer_controller cc  =new customer_controller(cs);
                               }
                               else{
                                   System.out.println("cant insert payment data");
                               }
                           }
                           else{
                                   System.out.println("cant insert Booking data");
                               }
                       }
                       catch (SQLException ex) {
                       System.out.println("SQL Error Occured");
                       }
                   }
                       
               }
           });
     
     Exit.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   frame.dispose();
               }
           });
     Bk.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   frame.dispose();
                   newbooking bb = new newbooking(cs);
               }
           });
     Exit.setBounds(40,290,100,30);
     Bk.setBounds(150,290,100,30);
     pay.setBounds(300,290,100,30);
               
     
     credit.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   
                   username.setBounds(120, 70 , 100 ,30);
                   password.setBounds(120, 120 , 100 ,30);
                   t_username.setBounds(230, 70 , 120 ,30);
                   t_password.setBounds(230, 120 , 120 ,30);
                   frame.add(username);
                   frame.add(password);
                   frame.add(t_username);
                   frame.add(t_password);
               }
           });
    }

    
}

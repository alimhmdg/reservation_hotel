/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import reservation_hotel.customer;

/**
 *
 * @author alimh
 */
public class customer_controller {
    private customer cs;
    private JFrame frame;
     private JButton C_booking,C_cancelBooking,C_updateBooking,C_giveFeedback,Logout,updateProflie;
   
    public customer_controller(customer cs){
        this.cs =cs;
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        frame.setResizable(false);
        frame.setTitle("Control Customer");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null); 
        C_booking       = new JButton("New Booking");
        C_cancelBooking = new JButton("Cancel Booking");
        C_updateBooking = new JButton("Update Booking");
        C_giveFeedback  = new JButton("Give Feedback");
        updateProflie = new JButton("Update Profile");
        Logout        = new JButton("Logout");
        frame.add(C_booking);
        frame.add(C_cancelBooking);
        frame.add(C_updateBooking);
        frame.add(C_giveFeedback);
        frame.add(updateProflie);
        frame.add(Logout);
        C_booking.setBounds(40,30,220,30);
        C_updateBooking.setBounds(40,80,220,30);
        C_cancelBooking.setBounds(40,130,220,30);
        C_giveFeedback.setBounds(40,180,220,30);
        updateProflie.setBounds(40,230,220,30);
        Logout.setBounds(40,280,220,30);
        Logout.addActionListener(new logout_action());
        C_cancelBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                canel_booking cb =new canel_booking(cs);
            }
        });
       C_updateBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                update_booking up = new update_booking(cs);
            }
        });
        //Logout.addActionListener(this);
        C_booking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                newbooking book = new newbooking(cs);
            }
        });
        
        C_giveFeedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                add_feedback feed = new add_feedback(cs);
            }
        });
        //updateProflie.addActionListener(this);
        
    }
    public class logout_action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.dispose();
            login log =new login();
        }
        
    }
}

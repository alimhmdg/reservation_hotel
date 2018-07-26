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
import reservation_hotel.admin;

/**
 *
 * @author alimh
 */
public class admin_controller {
    private admin ad; 
    private JFrame frame;
     private JButton controlRoom,controlUser,viewFeedback;
     private JButton C_booking,C_cancelBooking,C_updateBooking,C_giveFeedback,Logout,updateProflie;
 
    public admin_controller(admin ad){
        this.ad = ad;
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setResizable(false);
        frame.setTitle("Control Admin");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null); 
        controlRoom = new JButton("Control Room");
        controlUser = new JButton("Control User");
        updateProflie = new JButton("Update Profile");
        Logout        = new JButton("Logout");
        frame.add(controlRoom);
        frame.add(controlUser);
        frame.add(updateProflie);
        frame.add(Logout);
        controlRoom.setBounds(40,30,220,30);
        controlUser.setBounds(40,80,220,30);
        updateProflie.setBounds(40,130,220,30);
        Logout.setBounds(40,180,220,30);
        
        Logout.addActionListener(new logout_action());
       
// frame.controlRoom.addActionListener(this);
       // frame.controlUser.addActionListener(this);
     //   frame.Logout.addActionListener(this);
   //     frame.updateProflie.addActionListener(this);
    
    }
    public class logout_action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.dispose();
            login log =new login();
        }
        
    }
    
}

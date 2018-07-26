/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import reservation_hotel.customer;

/**
 *
 * @author alimh
 */
public class add_feedback {
    private JTextArea C_feedback;
    private JButton giveFeedback;
    private JFrame frame;
    private JButton Booking,Bk_controlCustomer;
    private JButton Register,BkLogin,Exit;
   
    public add_feedback(customer cus){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setResizable(false);
        frame.setTitle("Give FeedBack");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        C_feedback = new JTextArea();
        giveFeedback = new JButton("Feedback");
        Bk_controlCustomer = new JButton("Back");
        Exit = new JButton("Exit");
        frame.add(C_feedback);
        frame.add(giveFeedback);
        frame.add(Bk_controlCustomer);
        frame.add(Exit);
        giveFeedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String content = C_feedback.getText();
                
                try {
                    if(cus.give_feedback(content, new Date().toString()))
                    {
                        frame.dispose();
                        customer_controller cc = new customer_controller(cus);
                    }
                    else{
                        System.out.println("cant dd this feedback");
                    }
                } catch (SQLException ex) {
                    System.out.println("Sql Error Occured    feedback");
                }
            }
        });
        Bk_controlCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                customer_controller cc= new customer_controller(cus);
            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
            }
        });
        C_feedback.setBounds(40,40,320,100);
        Exit.setBounds(40,180,100,30);
        Bk_controlCustomer.setBounds(150,180,100,30);
        giveFeedback.setBounds(260,180,100,30);
    }
}

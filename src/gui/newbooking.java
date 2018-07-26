/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import reservation_hotel.customer;

/**
 *
 * @author alimh
 */
public class newbooking {
    private JFrame frame;
  
    private JLabel CL_type,CL_option,CL_numOfBed,CL_startDate,CL_endDate;
    private JTextField CT_startDate,CT_num_days;
    private JComboBox CC_Type,CC_Option;
    private JRadioButton one,two,three,four ;
    private ButtonGroup num_of_bed , day , month;
    private JButton Booking,Bk_controlCustomer;
    private JButton Exit;
    public newbooking(customer cs){
        frame =  new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,400);
        frame.setResizable(false);
        frame.setTitle("New Booking");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        CL_type  = new JLabel("Type Of Room ");
        CL_option   = new JLabel("Meal Flan ");
        CL_numOfBed = new JLabel("Number Of Beds ");
        CL_startDate= new JLabel("Start Date ");
        CL_endDate  = new JLabel("Num Days ");
        CT_startDate= new JTextField();
        CT_num_days  = new JTextField();
        String type [] ={"single","Double","Twin"};
        CC_Type     = new JComboBox(type);
        String option [] = {"Bed Only","Bed and Breakfast","Half Board","Full Board"};
        CC_Option   = new JComboBox(option);
        one         = new JRadioButton("One");
        two         = new JRadioButton("Two");
        three       = new JRadioButton("Three");
        four        = new JRadioButton("Four");
        num_of_bed  = new ButtonGroup();
        num_of_bed.add(one);
        num_of_bed.add(two);
        num_of_bed.add(three);
        num_of_bed.add(four);
        //
        
        //
        Booking = new JButton("Booking");
        Bk_controlCustomer = new JButton("Back");
        Exit = new JButton("Exit");
        frame.add(CL_type);
        frame.add(CL_option);
        frame.add(CL_numOfBed);
        frame.add(CL_startDate);
        frame.add(CL_endDate);
        frame.add(CT_startDate);
        frame.add(CT_num_days);
        frame.add(one);
        frame.add(two);
        frame.add(three);
        frame.add(four);
        frame.add(CC_Option);
        frame.add(CC_Type);
        frame.add(Booking);
        frame.add(Exit);
        Booking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String room_type = (String)CC_Type.getSelectedItem();
                String meal_flan = (String)CC_Option.getSelectedItem();
                String start_date = CT_startDate.getText();
                int num_days = Integer.parseInt(CT_num_days.getText());
                    frame.dispose();
                    System.out.println(meal_flan);
                    System.out.println(start_date);
                    System.out.println(num_days);
                    System.out.println(room_type);
                    pay p =new pay(cs , meal_flan ,start_date , num_days , room_type );
            }
        });
        Bk_controlCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                customer_controller  cc= new customer_controller(cs);
            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
            }
        });
        frame.add(Bk_controlCustomer);
        CL_type.setBounds(40,40,100,30);
        CC_Type.setBounds(150,40,250 ,30);
        CL_option.setBounds(40,90,100,30);
        CC_Option.setBounds(150,90,250,30);
        CL_numOfBed.setBounds(40,140,100,30);
        one.setBounds(150,140,60,30);
        two.setBounds(220,140,60,30);
        three.setBounds(280,140,70,30);
        four.setBounds(350,140,70,30);
        CL_startDate.setBounds(40,190,100,30);
        CT_startDate.setBounds(150,190,250,30);
        CL_endDate.setBounds(40,240,100,30);
        CT_num_days.setBounds(150,240,250,30);
        Exit.setBounds(40,290,100,30);
        Bk_controlCustomer.setBounds(150,290,100,30);
        Booking.setBounds(300,290,100,30);
        
    }
}

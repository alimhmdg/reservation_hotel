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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import reservation_hotel.customer;

/**
 *
 * @author alimh
 */
public class register {
   private JFrame frame;
   private JButton Register,BkLogin,Exit;
    private JLabel RL_username,RL_password,RL_confirmPassword,RL_email,RL_name,RL_gender,RL_phone,RL_nationalId;
    private JTextField RT_username,RT_email,RT_name,RT_phone,RT_nationalId;
    private JRadioButton male,female;
    private ButtonGroup gender;
    private JPasswordField RP_password,RP_confirmPassword;
   
    public register(){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setTitle("Register");
        frame.setLocationRelativeTo(null);
        RL_name        = new JLabel("Name ");
        RL_email       = new JLabel("Email ");
        RL_gender      = new JLabel("Gender ");
        RL_phone       = new JLabel("Phone ");
        RL_nationalId  = new JLabel("National ID ");
        RL_username    = new JLabel("Username ");
        RL_password    = new JLabel("Password ");
        RL_confirmPassword    = new JLabel("Confirm Password ");
        RT_username    = new JTextField();
        RP_password    = new JPasswordField();
        RP_confirmPassword    = new JPasswordField();
        RT_email       = new JTextField();
        RT_name        = new JTextField();
        RT_phone       = new JTextField();
        RT_nationalId  = new JTextField();
        male           = new JRadioButton("male");
        female         = new JRadioButton("female");
        gender         = new ButtonGroup();
        Register       = new JButton("Register");
        BkLogin        = new JButton("Back To Login");
        Exit           = new JButton("Exit");
        gender.add(male);
        gender.add(female);
        frame.setLayout(null);
        frame.add(RL_name);
        frame.add(RT_name);
        frame.add(RL_email);
        frame.add(RT_email);
        frame.add(RL_phone);
        frame.add(RT_phone);
        frame.add(RL_gender);
        frame.add(male);
        frame.add(female);
        frame.add(RL_nationalId);
        frame.add(RT_nationalId);
        frame.add(RL_username);
        frame.add(RT_username);
        frame.add(RL_password);
        frame.add(RP_password);
        frame.add(RL_confirmPassword);
        frame.add(RP_confirmPassword);
        frame.add(Register);
        frame.add(BkLogin);
        frame.add(Exit);
        
        Register.addActionListener(new reg_action());
        BkLogin.addActionListener(new back_action());
        Exit.addActionListener(new exit_action());
        
        RL_name.setBounds(35,20,150, 10);
        RT_name.setBounds(180,10,280, 30);
        RL_email.setBounds(35,70,150, 10);
        RT_email.setBounds(180,60,280, 30);
        RL_phone.setBounds(35,120,150, 10);
        RT_phone.setBounds(180,110,280, 30);
        RL_gender.setBounds(35,170,150, 10);
        male.setBounds(180,160,100, 30);
        female.setBounds(300,160,100, 30);
        RL_nationalId.setBounds(35,210,150, 10);
        RT_nationalId.setBounds(180,200,280, 30);
        RL_username.setBounds(35,260,150, 10);
        RT_username.setBounds(180,250,280, 30);
        RL_password.setBounds(35,310,150, 10);
        RP_password.setBounds(180,300,280, 30);
        RL_confirmPassword.setBounds(35,360,150, 10);
        RP_confirmPassword.setBounds(180,350,280, 30);
        Register.setBounds(180,410,100,30);
        BkLogin.setBounds(310,410,150,30);
        Exit.setBounds(35,410,100,30);
    }
   /*
     private JTextField RT_username,RT_email,RT_name,RT_phone,RT_nationalId;
    private JRadioButton male,female;
    private ButtonGroup gender;
    private JPasswordField RP_password,RP_confirmPassword;
   */ 
    public class reg_action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            customer cus = new customer();
            cus.mail = RT_email.getText();
            cus.name = RT_name.getText();
            cus.pass = RP_password.getText();
            cus.ssn = Integer.parseInt(RT_nationalId.getText());
            cus.user_name = RT_username.getText();
            cus.telephone = Integer.parseInt(RT_phone.getText());
            //cus.type_id = 1;
            
            try {
                if(cus.add_customer())
                { 
                    frame.dispose();
                    login log = new login();
                }
                else{
                    System.out.println("cant register user Information");
                }
            }
            catch (SQLException ex) {
                System.out.println("SQL error Occured");
            }
                
        }
        
    }
    
    public class back_action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.dispose();
            login log = new login();
        }
        
    }
    public class exit_action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.dispose();
        }
        
    }
}

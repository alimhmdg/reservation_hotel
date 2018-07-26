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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import reservation_hotel.*;

/**
 *
 * @author alimh
 */
public class login {
    private JFrame frame;
    
    private JButton Login;
    private JButton btnRegister;
    private JLabel username;
    private JLabel password;
    private JTextField user;
    private JTextField pass;
    
    public login(){       
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(380,200);
        frame.setResizable(false);
        frame.setTitle("Login");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
         Login = new JButton("Login");
        btnRegister = new JButton("Register");
        Login.addActionListener(new login_action());
        username = new JLabel("Username");
        password = new JLabel("Password");
        user = new JTextField("");
        pass = new JTextField("");
        frame.add(username);
        frame.add(password);
        frame.add(user);
        frame.add(pass);
        frame.add(Login);
        frame.add(btnRegister);
        btnRegister.addActionListener(new register_action());
        username.setBounds(20,20,100,10);
        user.setBounds(110,10,220,30);
        password.setBounds(20,70,100,10);
        pass.setBounds(110,60,220,30);
        Login.setBounds(110,110,100,30);
        btnRegister.setBounds(230,110,100,30);
        
}
 private class login_action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String mail = user.getText();
            String password = pass.getText();
            user u = new user();
            try {
               int x = u.login(mail, password);
                if(x!=0){
                    if (x==1){
                        admin Ad = new admin();
                        Ad.id = u.id;
                        Ad.mail = u.mail;
                        Ad.name = u.name;
                        Ad.pass = u.pass;
                        Ad.ssn = u.ssn;
                        Ad.telephone = u.telephone ;
                        Ad.type_id = u.type_id;
                        Ad.user_name = u.user_name;
                        frame.dispose();
                        admin_controller con = new admin_controller(Ad);
                    
                    }
                    if(x== 2){
                        customer cs = new customer();
                        
                        cs.id = u.id;
                        cs.mail = u.mail;
                        cs.name = u.name;
                        cs.pass = u.pass;
                        cs.ssn = u.ssn;
                        cs.telephone = u.telephone ;
                        cs.type_id = u.type_id;
                        cs.user_name = u.user_name;
                        customer_controller cus = new customer_controller(cs);
                        frame.dispose();
   
                    }
                }
                else{
                    System.out.println(x);
                    System.out.println(mail);
                    System.out.println(pass);
                    System.out.println("Invalid username or passsword");
                }
            } catch (SQLException ex) {
                System.out.println("sql error occured");
            }
        } 
}
 private class register_action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.dispose();
            register reg = new register();
        }
    
}
}
 

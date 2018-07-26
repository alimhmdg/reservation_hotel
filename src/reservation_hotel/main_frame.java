/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation_hotel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author alimh
 */
public class main_frame extends JFrame implements ActionListener{
    
    /*Login*/
    private JButton Login;
    private JButton btnRegister;
    private JLabel username;
    private JLabel password;
    private JTextField user;
    private JTextField pass;
    
    /*Register*/
    private JButton Register,BkLogin,Exit;
    private JLabel RL_username,RL_password,RL_confirmPassword,RL_email,RL_name,RL_gender,RL_phone,RL_nationalId;
    private JTextField RT_username,RT_email,RT_name,RT_phone,RT_nationalId;
    private JRadioButton male,female;
    private ButtonGroup gender;
    private JPasswordField RP_password,RP_confirmPassword;
    
    public void Login()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(380,200);
        this.setResizable(false);
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        //this.getContentPane().setBackground(Color.DARK_GRAY);
        Login = new JButton("Login");
        btnRegister = new JButton("Register");
        Login.addActionListener(this);
        username = new JLabel("Username");
        password = new JLabel("Password");
        user = new JTextField("");
        pass = new JTextField("");
        this.add(username);
        this.add(password);
        this.add(user);
        this.add(pass);
        this.add(Login);
        this.add(btnRegister);
        this.btnRegister.addActionListener(this);
        username.setBounds(20,20,100,10);
        user.setBounds(110,10,220,30);
        password.setBounds(20,70,100,10);
        pass.setBounds(110,60,220,30);
        Login.setBounds(110,110,100,30);
        btnRegister.setBounds(230,110,100,30);
    }
    public void Register()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setResizable(false);
        this.setTitle("Register");
        this.setLocationRelativeTo(null);
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
        this.setLayout(null);
        this.add(RL_name);
        this.add(RT_name);
        this.add(RL_email);
        this.add(RT_email);
        this.add(RL_phone);
        this.add(RT_phone);
        this.add(RL_gender);
        this.add(male);
        this.add(female);
        this.add(RL_nationalId);
        this.add(RT_nationalId);
        this.add(RL_username);
        this.add(RT_username);
        this.add(RL_password);
        this.add(RP_password);
        this.add(RL_confirmPassword);
        this.add(RP_confirmPassword);
        this.add(Register);
        this.add(BkLogin);
        this.add(Exit);
        this.Register.addActionListener(this);
        this.BkLogin.addActionListener(this);
        this.Exit.addActionListener(this);
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
    /*Admin*/
    private JButton controlRoom,controlUser,viewFeedback;
    public  void adminController()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,300);
        this.setResizable(false);
        this.setTitle("Control Admin");
        this.setLocationRelativeTo(null);
        this.setLayout(null); 
        controlRoom       = new JButton("Control Room");
        controlUser       = new JButton("Control User");
        updateProflie = new JButton("Update Profile");
        Logout        = new JButton("Logout");
        this.add(controlRoom);
        this.add(controlUser);
        this.add(updateProflie);
        this.add(Logout);
        this.controlRoom.setBounds(40,30,220,30);
        this.controlUser.setBounds(40,80,220,30);
        this.updateProflie.setBounds(40,130,220,30);
        this.Logout.setBounds(40,180,220,30);
        this.controlRoom.addActionListener(this);
        this.controlUser.addActionListener(this);
        this.Logout.addActionListener(this);
        this.updateProflie.addActionListener(this);
    }
    
    /*Receptionist*/
    private JButton controlcustomer,controlBooking;
    public void receptionistController()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,360);
        this.setResizable(false);
        this.setTitle("Control Receptionist");
        this.setLocationRelativeTo(null);
        this.setLayout(null); 
        controlBooking  = new JButton("Control Booking");
        controlcustomer = new JButton("Control Customer");
        controlRoom  = new JButton("Control Room");
        viewFeedback    = new JButton("View Feedback");
        updateProflie   = new JButton("Update Profile");
        Logout          = new JButton("Logout");
        this.add(controlBooking);
        this.add(controlcustomer);
        this.add(controlRoom);
        this.add(viewFeedback);
        this.add(updateProflie);
        this.add(Logout);
        this.controlBooking.setBounds(40,30,220,30);
        this.controlcustomer.setBounds(40,80,220,30);
        this.controlRoom.setBounds(40,130,220,30);
        this.viewFeedback.setBounds(40,180,220,30);
        this.updateProflie.setBounds(40,230,220,30);
        this.Logout.setBounds(40,280,220,30);
        this.controlBooking.addActionListener(this);
        this.controlcustomer.addActionListener(this);
        this.controlRoom.addActionListener(this);
        this.viewFeedback.addActionListener(this);
        this.Logout.addActionListener(this);
        this.updateProflie.addActionListener(this);
        
    }
    /*Customer*/
    private JButton C_booking,C_cancelBooking,C_updateBooking,C_giveFeedback,Logout,updateProflie;
    public void customerController()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,400);
        this.setResizable(false);
        this.setTitle("Control Customer");
        this.setLocationRelativeTo(null);
        this.setLayout(null); 
        C_booking       = new JButton("New Booking");
        C_cancelBooking = new JButton("Cancel Booking");
        C_updateBooking = new JButton("Update Booking");
        C_giveFeedback  = new JButton("Give Feedback");
        updateProflie = new JButton("Update Profile");
        Logout        = new JButton("Logout");
        this.add(C_booking);
        this.add(C_cancelBooking);
        this.add(C_updateBooking);
        this.add(C_giveFeedback);
        this.add(updateProflie);
        this.add(Logout);
        this.C_booking.setBounds(40,30,220,30);
        this.C_updateBooking.setBounds(40,80,220,30);
        this.C_cancelBooking.setBounds(40,130,220,30);
        this.C_giveFeedback.setBounds(40,180,220,30);
        this.updateProflie.setBounds(40,230,220,30);
        this.Logout.setBounds(40,280,220,30);
        this.Logout.addActionListener(this);
        this.C_booking.addActionListener(this);
        this.C_giveFeedback.addActionListener(this);
        this.updateProflie.addActionListener(this);
        
    }
    
    
    private JLabel CL_type,CL_option,CL_numOfBed,CL_startDate,CL_endDate;
    private JTextField CT_startDate,CT_endDate;
    private JComboBox CC_Type,CC_Option;
    private JRadioButton one,two,three,four;
    private ButtonGroup num_of_bed;
    private JButton Booking,Bk_controlCustomer;
    private void newBooking()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,400);
        this.setResizable(false);
        this.setTitle("New Booking");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        CL_type     = new JLabel("Type Of Room ");
        CL_option   = new JLabel("Meal Flan ");
        CL_numOfBed = new JLabel("Number Of Beds ");
        CL_startDate= new JLabel("Start Date ");
        CL_endDate  = new JLabel("End Date ");
        CT_startDate= new JTextField();
        CT_endDate  = new JTextField();
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
        Booking     = new JButton("Booking");
        Bk_controlCustomer = new JButton("Back");
        Exit        = new JButton("Exit");
        this.add(CL_type);
        this.add(CL_option);
        this.add(CL_numOfBed);
        this.add(CL_startDate);
        this.add(CL_endDate);
        this.add(CT_startDate);
        this.add(CT_endDate);
        this.add(one);
        this.add(two);
        this.add(three);
        this.add(four);
        this.add(CC_Option);
        this.add(CC_Type);
        this.add(Booking);
        this.add(Exit);
        this.Booking.addActionListener(this);
        this.Bk_controlCustomer.addActionListener(this);
        this.Exit.addActionListener(this);
        this.add(Bk_controlCustomer);
        this.CL_type.setBounds(40,40,100,30);
        this.CC_Type.setBounds(150,40,250 ,30);
        this.CL_option.setBounds(40,90,100,30);
        this.CC_Option.setBounds(150,90,250,30);
        this.CL_numOfBed.setBounds(40,140,100,30);
        this.one.setBounds(150,140,60,30);
        this.two.setBounds(220,140,60,30);
        this.three.setBounds(280,140,70,30);
        this.four.setBounds(350,140,70,30);
        this.CL_startDate.setBounds(40,190,100,30);
        this.CT_startDate.setBounds(150,190,250,30);
        this.CL_endDate.setBounds(40,240,100,30);
        this.CT_endDate.setBounds(150,240,250,30);
        this.Exit.setBounds(40,290,100,30);
        this.Bk_controlCustomer.setBounds(150,290,100,30);
        this.Booking.setBounds(300,290,100,30);
        
        
    }
    /*Update Profile*/
    private JButton Update;
    private void updateProfile()
    {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setResizable(false);
        this.setTitle("Update Profile");
        this.setLocationRelativeTo(null);
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
        Update         = new JButton("Update");
        Bk_controlCustomer = new JButton("Back");
        Exit           = new JButton("Exit");
        gender.add(male);
        gender.add(female);
        this.setLayout(null);
        this.add(RL_name);
        this.add(RT_name);
        this.add(RL_email);
        this.add(RT_email);
        this.add(RL_phone);
        this.add(RT_phone);
        this.add(RL_gender);
        this.add(male);
        this.add(female);
        this.add(RL_nationalId);
        this.add(RT_nationalId);
        this.add(RL_username);
        this.add(RT_username);
        this.add(RL_password);
        this.add(RP_password);
        this.add(RL_confirmPassword);
        this.add(RP_confirmPassword);
        this.add(Update);
        this.add(Bk_controlCustomer);
        this.add(Exit);
        this.Update.addActionListener(this);
        this.Bk_controlCustomer.addActionListener(this);
        this.Exit.addActionListener(this);
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
        Bk_controlCustomer.setBounds(180,410,100,30);
        Update.setBounds(310,410,150,30);
        Exit.setBounds(35,410,100,30);
    }
    private JTextArea C_feedback;
    private JButton giveFeedback;
    private void giveFeedback()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,300);
        this.setResizable(false);
        this.setTitle("Give FeedBack");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        C_feedback = new JTextArea();
        giveFeedback = new JButton("Feedback");
        Bk_controlCustomer = new JButton("Back");
        Exit = new JButton("Exit");
        this.add(C_feedback);
        this.add(giveFeedback);
        this.add(Bk_controlCustomer);
        this.add(Exit);
        this.giveFeedback.addActionListener(this);
        this.Bk_controlCustomer.addActionListener(this);
        this.Exit.addActionListener(this);
        this.C_feedback.setBounds(40,40,320,100);
        this.Exit.setBounds(40,180,100,30);
        this.Bk_controlCustomer.setBounds(150,180,100,30);
        this.giveFeedback.setBounds(260,180,100,30);
        
    }
    public static void main(String[] args) {
        main_frame obj = new main_frame();
        obj.setVisible(true);
        obj.Login();
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        Object ob = ae.getSource();
        if(ob.equals(Login)){
            String check = String.valueOf(user.getText());
            getContentPane().removeAll();
            if(check.equals("1"))
            {
            this.adminController();
            }
            else if(check.equals("2"))
            {
            this.receptionistController();  
            }
            else if(check.equals("3"))
            {
            this.customerController();  
            }
            else
            {
                JOptionPane.showMessageDialog(Login,"Username Or Password Invalid");
            }
        }
        else if(ob.equals(btnRegister))
        {
        }
    }
}

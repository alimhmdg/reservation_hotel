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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import reservation_hotel.booking_manger;
import reservation_hotel.customer;

/**
 *
 * @author alimh
 */
public class update_booking {
    private JFrame frame ;
    private ArrayList<booking_manger> list;
    private JLabel Start_date , room_num , days_num , board_option;
    private  JTextField[]  s_date,  d_num , b_option;
    private JLabel[] r_num ;
    private  JButton []update_button;
    private JButton  Bk ,Exit;
    
    public update_booking(customer cs){
        try{list = cs.view_booking();}catch(SQLException ex){System.out.println("sql error occured updatebooking");}
        frame =  new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,400);
        frame.setResizable(false);
        frame.setTitle("payment");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        Exit = new JButton("Exit");
        Bk = new JButton("back");
        Exit.setBounds(40,290,100,30);
        Bk.setBounds(500,290,100,30);
        frame.add(Exit);
        frame.add(Bk);
        Start_date = new JLabel("start_date");
        Start_date.setBounds(30, 30, 100, 30);
        room_num = new JLabel("room number");
        room_num.setBounds(130, 30, 100, 30);
        
        days_num = new JLabel("num days");
        
        days_num.setBounds(230, 30, 100, 30);
        board_option = new JLabel("board_option");
        board_option.setBounds(330, 30, 100, 30);
        frame.add(Start_date);
        frame.add(days_num);
        frame.add(room_num);
        frame.add(board_option);
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
                   customer_controller bb = new customer_controller(cs);
               }
           });
   
        if(list!=null){    
            s_date  =  new JTextField[list.size()];
            r_num  =  new JLabel[list.size()];
            d_num  =  new JTextField[list.size()];
            b_option  =  new JTextField[list.size()];
            update_button = new JButton[list.size()];
            
            int y = 60;
            for(int k = 0 ; k < list.size() ; k++){
                s_date[k] = new JTextField();
                s_date[k].setText(list.get(k).start_date);
                r_num[k] = new JLabel();
                r_num[k].setText(list.get(k).room_num+"");
                d_num[k] = new JTextField();
                d_num[k].setText(list.get(k).num_days+"");
                b_option[k] = new JTextField();
                b_option[k].setText(list.get(k).board_option);
                update_button[k] = new JButton("update");
                
                s_date[k].setBounds(30,y ,100 ,30 );
                r_num[k].setBounds(130,y ,100 ,30 );
                d_num[k].setBounds(230,y ,100 ,30 );
                b_option[k].setBounds(330,y ,100 ,30 );
                update_button[k].setBounds(430,y ,100 ,30 );
                
                frame.add(s_date[k]);
                frame.add(r_num[k]);
                frame.add(d_num[k]);
                frame.add(b_option[k]);
                frame.add(update_button[k]);
                update_button[k].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for(int k  =0 ; k<list.size() ; k++){
                        if(ae.getSource() == update_button[k]){
                            String start_date = s_date[k].getText();
                            int room_number = Integer.parseInt(r_num[k].getText());
                            int days_number = Integer.parseInt(d_num[k].getText());
                            String board_option = b_option[k].getText();
                            try {
                                cs.update_booking(list.get(k).room_id, start_date, days_number, board_option, cs.id, 0, list.get(k).id, room_number);
                                frame.dispose();
                                update_booking up  =new update_booking(cs);
                            } catch (SQLException ex) {
                                System.out.println("sql error occured  update_booking");
                            }
                        }
                        }
                    }
                });
                y+= 30;
            }
            
            
            }
        }
}

    

   

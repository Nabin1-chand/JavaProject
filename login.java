/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeemanagement;

/**
 *
 * @author chand
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class login implements ActionListener {
    JFrame  f;
    JLabel l1, l2, l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2, b3;
    public Connection c;
    public Statement s;
    
    public login(){
         f = new JFrame("Login");
         f. setLayout(null);
         f.setVisible(true);
         f.setLocation(200, 150);
         f.getContentPane().setBackground(new Color(255, 255, 204));
         
         
         l3 = new JLabel("Employee System");
         l3.setBounds(140, 20, 390,55);
         l3.setBackground(Color.cyan);
         l3.setFont(new Font("ebrima", Font.BOLD, 20));
         l3.setForeground(Color.RED);
         f.add(l3);
         l1 = new JLabel("username");
         l1.setBounds(140,100,100,30);
         f.add(l1);
         
         t1 = new JTextField();
         t1.setBounds(250,100, 200,30);
         f.add(t1);
         
         l2 = new JLabel("password");
         l2.setBounds(140,150,100,30);
         f.add(l2);
         
         t2 = new JPasswordField();
         t2.setBounds(250,150,200,30);
         f.add(t2);
         
         b1 = new JButton("login");
         b1.setBounds(170,220, 120,30);
         b1.setFont(new Font("serif", Font.BOLD,15));
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.addActionListener(this);
         f.add(b1);
         
         b2 = new JButton("Cancel");
         b2.setBounds(240, 280,120,30);
         b2.setFont(new Font("serif",Font.BOLD,15));
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.addActionListener(this);
         f.add(b2);
         
         b3 = new JButton("Sign Up");
         b3.setBounds(240, 280,120,30);
         b3.setFont(new Font("serif",Font.BOLD,15));
         b3.setBackground(Color.BLACK);
         b3.setForeground(Color.WHITE);
         b3.addActionListener(this);
         f.add(b3);
    }
        public void actionPerformed(ActionEvent e){
            try{
                String u, p ,q;
                u = t1.getText();
                p = t2.getText();
                Class.forName("com.mysql.jdbc.Driver");
                 c =  DriverManager.getConnection("jdbc:mysql:///employee","root","");
                 s = c.createStatement();
                 if(e.getSource()==b1){
                 q = "select * from login where user ='" + u "' and pass ='" + p +"' ";
                     ResultSet r = s.executeQuery(q);
                     if(r.next()){
                         f.setVisible(false);
                         new detail();
                     }
                     else{
                         JOptionPane.ShowMessageDialog(null, "username or password invalid");
                     }
                     else if(e.getSource()==b2){
                                t1.setText("");
                                  t2.setText("");
                             }
                     else if(e.getSource()==b3){
                             f.setVisible(false);
                             new add();
                             }
                 }
                 catch(Exception ex){
                         Logger.getLogger(login.class.getName()).log(Level.SEVERE, null ex);               
            }         
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
        public static void main(String args[]){
            new login();
}
}
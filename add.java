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

public class add extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JTextField t1,t5,t6,t8,t9,t10;
    JButton b1, b2;
    JRadioButton r1, r2;
    JCheckBox c1, c2, c3;
    ButtonGroup bg;
    JTextArea ta1;
    JComboBox cb1, cb2, cb3;
    
    String day [] = new  String[31];
    String month [] ={"1","2","3","4","5","6","7","8","9","10","11","12"};
    String year[] = new String[50];
    int i;
    
    Connection c;
    Statement s;
    public add(){
        setLayout(null);
        setBounds (250,50, 810,530);
        setVisible(true);
        getContentPane().setBackground(new Color(204,255,204));
        l1 = new JLabel("New Employee Records");
        l1.setFont(new Font("Ebrima",1,24));
        l1.setBounds(297,26,263,40);
        add(l1);
        
        l2 = new JLabel("Name");
        l2.setFont(new Font("Ebrima",1,24));
        l2.setBounds(297,26,263,40);
        add(l2);
        
        
       t1 = new JTextField();
       t1.setBounds(194,123,167,25);
       add(t1);
    
        l3 = new JLabel("Gender");
        l3.setFont(new Font("Ebrima",1,24));
        l3.setBounds(297,26,263,40);
        add(l3);
        
        r1 = new JRadioButton("male", true);
        r2= new JRadioButton("female");
        r1.setBounds(194,182,70,25);
        r2.setBounds(274,182,70,25);
        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        add(r1);
        add(r2);
        
        l4 = new JLabel("Age");
        l4.setFont(new Font("Ebrima",1,24));
        l4.setBounds(297,26,263,40);
        add(l4);
        
    
       t5 = new JTextField();
       t5.setBounds(194,123,167,25);
       add(t5);
       
        l5 = new JLabel("Job Post");
        l5.setFont(new Font("Ebrima",1,24));
        l5.setBounds(297,26,263,40);
        add(l5);
    
        t6 = new JTextField();
        t6.setBounds(194,123,167,25);
        add(t6);
        
        c1 = new JCheckBox("Reading");
        c2 = new JCheckBox("playing");
        c3 = new JCheckBox("Coding", true);
        c1.setBounds(195,359,70,25);
        c2.setBounds(265,359,70,25);
        c3.setBounds(340,359,70,25);
        add(c1);
        add(c2);
        add(c3);
        
        l5 = new JLabel("Address");
        l5.setFont(new Font("Ebrima",1,24));
        l5.setBounds(297,26,263,40);
        add(l5);
        
    
        ta1 = new JTextArea();
        ta1.setBounds(553,170,180,55);
        
        l6 = new JLabel("Education");
        l6.setFont(new Font("Ebrima",1,24));
        l6.setBounds(297,26,263,40);
        add(l6);
        
         t8 = new JTextField();
        t8.setBounds(194,123,167,25);
        add(t8);
        
        l7 = new JLabel("Date of Birth");
        l7.setFont(new Font("Ebrima",1,24));
        l7.setBounds(297,26,263,40);
        add(l7);
        
        for(i=1; i<32; i++){
            day[i-1] = String.valueOf(i);
            
        }
        
        for(i= 1970; i<2020; i++){
            year[i-1970] = String.valueOf(i);
            
        }
        cb1 = new JComboBox(day);
        cb1.setBounds(553,300,50,25);
        add(cb1);
        
         cb2 = new JComboBox(month);
        cb2.setBounds(553,300,50,25);
        add(cb2);
        
        b1 = new JButton("Add");
         b1.setBounds(170,220, 120,30);
         b1.setFont(new Font("serif", Font.BOLD,15));
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.addActionListener(this);
         add(b1);
         
          b2 = new JButton("Cancel");
         b2.setBounds(170,220, 120,30);
         b2.setFont(new Font("serif", Font.BOLD,15));
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.addActionListener(this);
         add(b2);
    }
    public void actionPerformed(ActionEvent e){
    String a1,a2, a3,a41, a42, a43, a5, = "", a6,a7,a8,a9;
    a1 = t1.getText();
    
    if(r1.isSelected()){
        a2= "male";
    }  
    else{
        a2= "female";
    }
    if(c1.isSelected()){
        a5 ="reading";
        
    }
    if(c2.isSelected()){
        a5 = a5 + "playing";
    }
    if(c3.isSelected()){
        a5 = a5 + "coding";
    }
    a41 = String.valueOf(cb1.getSelectedItem());
    a42 = String.valueOf(cb2.getSelectedItem());
    a43 = String.valueOf(cb3.getSelectedItem());
   
    a9 = a41 + "-" + a42 + "-" + a43;
    
    a3 = t5.getText();
    a6 = t6.getText();
     a7 = ta1.getText();
     a8= t8.getText();
    }
    if(!a1.equals("") &&!a7.equals("") &&!a6.equals("") &&!a6.equals("")){
       if(e.getSource() ==b1){
           try{
               Class.forName("com.mysql.jdbc.Driver");
               c = DriverManager.getConnection("jdbc:mysq:///employee", "root","");
               s = c.createStatement();
               
          String q = "insert into emp {name, gender ,age, job, hobbies, phone,address,dob,education) values('" +a1 + "','" +a2 '"+ a3+ '", '",+ a5 + '", + a6 +'" +a7 '"+ a8+ '",'" +a9 '"+ a10+ '")";
          s.executeUpdate(q);
          setVisible(false);
          new detail();
          JOptionPane.showMessageDialog(null, "data Recorded sucessfully");
           }
           catch (Exception ex){
               Logger.getLogger(add.class.getName()).log(Level.SEVERE, null ,ex);
           }
           
       } else if(e.getSource()==b2){
           setVisible(false);
           new detail();
       }
       else {
           JOptionPane.showMessageDialog(null, "Fill up the all area");
       }
    }

   
    public static void main(String args[]){   
        new add();
    
     }
}

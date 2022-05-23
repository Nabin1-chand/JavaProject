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

public class detail extends JFrame implements ActionListener {
    
    JLabel l1;
    JButton b1, b2 , b3,b4;
     Connection c;
    Statement s;
    public detail() {
        setLayout(null);
        setBounds (250,50, 810,530);
        setVisible(true);
        getContentPane().setBackground(new Color(204,255,204));
        l1 = new JLabel("Employee Details");
        l1.setFont(new Font("Ebrima",1,24));
        l1.setBounds(297,26,263,40);
        add(l1);
        
        
         b1 = new JButton("Add");
         b1.setBounds(170,220, 120,30);
         b1.setFont(new Font("serif", Font.BOLD,15));
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.addActionListener(this);
         add(b1);
         
         b2 = new JButton("View");
         b2.setBounds(170,220, 120,30);
         b2.setFont(new Font("serif", Font.BOLD,15));
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.addActionListener(this);
         add(b2);
         
         b3 = new JButton("Update");
         b3.setBounds(170,220, 120,30);
         b3.setFont(new Font("serif", Font.BOLD,15));
         b3.setBackground(Color.BLACK);
         b3.setForeground(Color.WHITE);
         b3.addActionListener(this);
         add(b3);
         
         b4= new JButton("Delete");
         b4.setBounds(170,220, 120,30);
         b4.setFont(new Font("serif", Font.BOLD,15));
         b4.setBackground(Color.BLACK);
         b4.setForeground(Color.WHITE);
         b4.addActionListener(this);
         add(b4);
         
    }
    public void actionPerformed(ActionEvent e){
       try{
               Class.forName("com.mysql.jdbc.Driver");
       }  
        catch (Exception ex){
               Logger.getLogger(detail.class.getName()).log(Level.SEVERE, null ,ex);
           }
         try{
             s = c.createStatement();
         } catch(SQLException ex){
              Logger.getLogger(add.class.getName()).log(Level.SEVERE, null ,ex);  
         }
         if(e.getSource()== b1){
             setVisible(false);
             new add();
             
         }else if(e.getSource()==b2){
          setVisible(false);
          new view();
         }
         else if(e.getSource()== b3){
          int msg = Integer.parseInt(JOptionPane.showInputDialog("enter the id"));
          try{
              q = "delete from emp where id ='" + msg + "'";
              s.executeUpdate(q);
              JOptionPane.showMessageDialog(null, "data deleted sucessfully");
              setVisible(false);
              new detail();
              
          }catch (SQLException ex){
              Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
              
          } else if(e.getSource()==b4){
                  setVisible(false);
                  int id = Integer.parseInt(JOptionPane.showInputDialog("enter the id"));
                  new update(id);
                  
                  }
         
              
         }
   
    }
    public static void main(String args[]){
     new detail();
    }
    
}

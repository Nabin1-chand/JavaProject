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


public class view extends JFrame implements ActionListener{
    JTable t;
    JButton b1;
    JLabel l1;
    String q;
     
    String x[] ={"ID",  "NAME", "GENDER", "AGE", "JOB POST", "HOBBIES", "PHONE", "ADDRESS", "EDUCATION","DATE OF BIRTH"};
    
    String row[][]= new String[100][11];
    Connection c;
    Statement s;
    Result  rs;
    int i =0, j = 0;
    
    public view(){
        setBounds(100, 100, 700);
        setVisible(true);
        setlayout(null);
        getContentPane().setBackground(new Color(255,255, 204));
        
        l1 = new JLabel("Employees Details");
        l1.setBounds(350, 20,300,50);
        add(l1);
        
        b1 = new JButton("Back");
        b1.setBounds(400,470,150,45);
        add(b1);
        b1.addActionListener(this);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
        }catch(ClassNotFoundException ex){
         Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
         
        }
        try{
            c = DriverManager.getConnection("jdbc;mysql:///employee", "root", "");
        } catch (SQLException ex){
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
            
        }     
        q = "select * from emp";
        try{
            rs = s.executeQuery(q);
            
        }catch(SQLException ex){
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            while(rs.next()){
                row[i][j++] = String.valueOf(rs.getInt(1));
                row[i][j++] = rs.getString(2);
                row[i][j++] = rs.getString(3);
                row[i][j++] = rs.getString(4);
                row[i][j++] = rs.getString(5);
                row[i][j++] = rs.getString(6);
                row[i][j++] = rs.getString(7);
                row[i][j++] = rs.getString(8);
                row[i][j++] = rs.getString(9);
                row[i][j++] = rs.getString(10);
                row[i][j++] = rs.getString(11);
                i++;
                j=0;
            }
        }catch(SQLException ex){
            Logger.getLogger(view.class.getName()).log(level.SERVER,null,ex);
            
        }
        t = new JTable (row , x);
        JScrollPane sp = new JScrollPane(t);
        sp.setBounds(20,110,900,300);
        add(sp);
        
    }
   public void actionPerformed(ActionEvent e){
    setVisible(false);
    new detail();
   }
   public static void main(String [] args){
   new view();
   }
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Model.MyDbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ockersz
 */
public class MCustomer {
    
    public int registerCustomer(String fname,String lname,String tp,String nic,String email)
    {
        int i = 0;
        try{
        Statement st = MyDbConnection.getConnection().createStatement();
        i = st.executeUpdate("INSERT INTO `customer`( `first_name`, `last_name`, `tp`, `nic`, `email`) VALUES ('"+fname+"','"+lname+"','"+tp+"','"+nic+"','"+email+"')");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return i;
        
        
    }
    public int getMaxId()
    {
        int id = 0;
         try{
             Statement st = MyDbConnection.getConnection().createStatement();
             ResultSet rs = st.executeQuery("SELECT MAX(customer_id) FROM `customer`");
             
             while(rs.next())
             {
                 id = rs.getInt(1);
             }
         }
         catch(SQLException e)
         {
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
        return id;
    }
    
    public ResultSet getCustomerByContact(String contact)
    {
         ResultSet rs = null;
        try{
        Statement st = MyDbConnection.getConnection().createStatement();
        rs = st.executeQuery("SELECT * FROM `customer` WHERE tp = '"+contact+"'");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
    }
    
    public int updateCustomer(String fname,String lname,String tp,String nic,String email,String existTp)
    {
        int i = 0;
        try{
        Statement st = MyDbConnection.getConnection().createStatement();
        i = st.executeUpdate("UPDATE `customer` SET `first_name`='"+fname+"',`last_name`='"+lname+"',`tp`='"+tp+"',`nic`='"+nic+"',`email`='"+email+"' WHERE `tp`='"+existTp+"'");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return i;
    }
}

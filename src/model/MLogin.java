/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ockersz
 */
public class MLogin {
    

    public int getEmpNumber(String username)
    {
        int i = 0;
        try{
            
            Statement st = MyDbConnection.getConnection().createStatement();
            ResultSet result = st.executeQuery("Select eno from employee_login_credentials where username = '"+username+"'");
            if(result.next())
            {
                i = result.getInt(1);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Data Transit Failed \n\r" + e.getClass() + "\n\r" + e.getMessage(), "Login Details Management", JOptionPane.INFORMATION_MESSAGE);
        }        
        return i ;
    }
    
   public boolean submitLoginDetails(String username, String password)
    {
        boolean i = false;
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            ResultSet result = st.executeQuery("Select * from employee_login_credentials WHERE username='"+username+"' and password = '"+password+"' ");
            if(result.next())
            {
                i = true;
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Data Transit Failed \n\r" + e.getClass() + "\n\r" + e.getMessage(), "Login Details Management", JOptionPane.INFORMATION_MESSAGE);
        }
        return (i);  
    }
    
    public String checkUsernameExist(String username)
    {
        String uname= "";
        try{
        Statement st = MyDbConnection.getConnection().createStatement();
        ResultSet rs = st.executeQuery("Select username FROM employee_login_credentials WHERE username ='"+username+"'");
        if(rs.next())
        {
            uname = rs.getString(1);
        }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return uname;
    }
    
    public int registerEmployee(String fname,String lname,String tp,String address,String gender,String email)
    {   int i = 0;
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            i = st.executeUpdate("INSERT INTO `employee`( `first_name`, `last_name`, `tp`, `address`, `gender`, `email`) VALUES ('"+fname+"','"+lname+"','"+tp+"','"+address+"','"+gender+"','"+email+"')");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return i ;
    }
    
    public int getMaxId()
    {   
        int i = 0;
    
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(employee_id) FROM `employee`");
            if(rs.next())
            {
                i = rs.getInt(1);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
       return i; 
    }
    
    public void insertIntoEmpCred(String username,String password)
    {
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            st.executeUpdate("INSERT INTO `employee_login_credentials` (`username`, `password`, `eid`) VALUES ('"+username+"', '"+password+"', '"+getMaxId()+"')");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}

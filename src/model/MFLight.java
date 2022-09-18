/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Model.MyDbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Ockersz
 */
public class MFLight {
    public int addNewFlight(String flight_name,String source,String destination,Date date,String arrivaltime,String departuretime,int price,int no_of_seats)
    {
        int i=0;
        String dateadded;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dateadded = format.format(date);
        try{
        Statement st=MyDbConnection.getConnection().createStatement();
        i=st.executeUpdate("INSERT INTO `flight`(`name`, `source`, `destination`, `date`, `arrival_time`, `departure_time`, `price`, `no_of_seats`) VALUES ('"+flight_name+"','"+source+"','"+destination+"','"+dateadded+"','"+arrivaltime+"','"+departuretime+"','"+price+"','"+no_of_seats+"')");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
         
        return i;
        
    }
    public int updateFlight(int flight_id,String flight_name,String source,String destination,Date date,String arrivaltime,String departuretime,int price,int no_of_seats){
         int i=0;
        String dateadded;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dateadded = format.format(date);
        try{
        Statement st=MyDbConnection.getConnection().createStatement();
        i=st.executeUpdate("UPDATE `flight` SET `name`='"+flight_name+"',`source`='"+source+"',`destination`='"+destination+"',`date`='"+dateadded+"',`arrival_time`='"+arrivaltime+"',`departure_time`='"+departuretime+"',`price`='"+price+"',`no_of_seats`='"+no_of_seats+"' WHERE `flight_id`='"+flight_id+"'");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
         
        return i;
    }
    public int deleteFlight(int flight_id){
         int i=0;
         try{
        Statement st=MyDbConnection.getConnection().createStatement();
        i=st.executeUpdate("DELETE FROM `flight` WHERE `flight_id`='"+flight_id+"'");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
         
        return i;
        
    }
    
    public ResultSet getFlightById(int flight_id)
    {
        ResultSet rs = null;
        try{
        Statement st = MyDbConnection.getConnection().createStatement();
        rs = st.executeQuery("SELECT * FROM `flight` where flight_id = '"+flight_id+"'");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
    }
     public ResultSet getFlight()
    {
        ResultSet rs = null;
        try{
        Statement st = MyDbConnection.getConnection().createStatement();
        rs = st.executeQuery("SELECT * FROM `flight` ");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
    }
     
     public int getMaxId()
     {
         int id = 0;
         try
         {
             Statement st = MyDbConnection.getConnection().createStatement();
             ResultSet rs = st.executeQuery("SELECT MAX(flight_id) FROM `flight`");
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
     
     public ResultSet getFlightBySource(String source)
     {
          ResultSet rs = null;
        try{
        Statement st = MyDbConnection.getConnection().createStatement();
        rs = st.executeQuery("SELECT * FROM `flight` where source = '"+source+"' ");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
     }
     public ResultSet getFlightByDestination(String destination)
     {
          ResultSet rs = null;
        try{
        Statement st = MyDbConnection.getConnection().createStatement();
        rs = st.executeQuery("SELECT * FROM `flight` where destination = '"+destination+"' ");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
     }
     
     public ResultSet getFlightBySourceAndDestination(String source, String destination)
     {
          ResultSet rs = null;
        try{
        Statement st = MyDbConnection.getConnection().createStatement();
        rs = st.executeQuery("SELECT * FROM `flight` where source = '"+source+"'destination = '"+destination+"' ");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
     }

}

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
public class MTicket {
       public int bookNewTicket(int no_of_seats,int flight_id,int price){
        int i=0;
         try{
        Statement st=MyDbConnection.getConnection().createStatement();
        i=st.executeUpdate("INSERT INTO `ticket`( `no_of_seats`, `price`, `fid`) VALUES ('"+no_of_seats+"','"+price+"','"+flight_id+"')");
         }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
         
        return i;
    }
       public int insertCustomerBookTicket(int cus_id){
        int i=0;
         try{
        Statement st=MyDbConnection.getConnection().createStatement();
        i=st.executeUpdate("INSERT INTO `customer_book_flight`(`tno`, `cid`) VALUES ('"+getMaxId()+"','"+cus_id+"')");
         }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
         
        return i;
    }
       
    
       public int getMaxId()
    {   
        int i = 0;
    
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(ticket_id) FROM `ticket`");
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
       public int cancelTicket(int flight_id,int customer_id,int ticket_no){
           int i=0;
           try{
        Statement st=MyDbConnection.getConnection().createStatement();
        i=st.executeUpdate("DELETE FROM `ticket` WHERE `flight_id`='"+flight_id+"'");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
         
        return i;
        
    }
       public ResultSet searchTicket(String contact)
       {
           ResultSet rs = null;
           
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
             rs = st.executeQuery("SELECT\n" +
"	\n" +
"  customer.tp,\n" +
"  customer.first_name,\n" +
"  ticket.ticket_id,\n" +
"  ticket.no_of_seats,\n" +
"  ticket.price,\n" +
"  flight.source,\n" +
"  flight.destination,\n" +
"  flight.arrival_time,\n" +
"  flight.departure_time,\n" +
"  flight.date,\n" +
"  customer.customer_id,\n" +
"  flight.flight_id\n" +
"FROM customer\n" +
"JOIN customer_book_flight\n" +
"  ON customer.customer_id = customer_book_flight.cid\n" +
"JOIN ticket\n" +
"  ON customer_book_flight.tno = ticket.ticket_id\n" +
"JOIN flight\n" +
"  ON flight.flight_id = ticket.fid\n" +
"  WHERE customer.tp = '"+contact+"';");
           
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs;
       }
       
    
}

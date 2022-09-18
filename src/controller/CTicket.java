/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.sql.ResultSet;
import model.MFLight;
import model.MTicket;

/**
 *
 * @author Ockersz
 */
public class CTicket {
 public static int bookNewTicket(int no_of_seats,int flight_id,int price){
      int i=0;
         MTicket ticket=new MTicket();
         i=ticket.bookNewTicket(no_of_seats, flight_id,price);
         
         return i;
 }
 
 public static int insertCustomerBookTicket(int cus_id){
     int i = 0;
     MTicket ticket = new MTicket();
      i = ticket.insertCustomerBookTicket(cus_id);
     return 0;
     
 }
 public static  int cancelTicket(int flight_id,int customer_id,int ticket_no){
     int i=0;
         MFLight flight=new MFLight();
         i=flight.deleteFlight(flight_id);
         return i ;
         
 }
 public static int getMaxId()
 {
    
     MTicket ticket = new MTicket();
    int  i = ticket.getMaxId();
     return i;
 }
  public static ResultSet searchTicket(String contact)
  {
      MTicket ticket = new MTicket();
      ResultSet  i = ticket.searchTicket(contact);
      return i;
  }
 
}

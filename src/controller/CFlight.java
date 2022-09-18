/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import java.util.Date;
import model.MFLight;

/**
 *
 * @author Ockersz
 */
public class CFlight {
     public static int addNewFlight(String flight_name,String source,String destination,Date date,String arrivaltime,String departuretime,int price,int no_of_seats){
         int i=0;
         MFLight flight=new MFLight();
         i=flight.addNewFlight(flight_name, source, destination, date, arrivaltime, departuretime, price, no_of_seats);
             
         
         return i;
     }
    public static int updateFlight(int flight_id,String flight_name,String source,String destination,Date date,String arrivaltime,String departuretime,int price,int no_of_seats){
        int i=0;
         MFLight flight=new MFLight();
         i=flight.updateFlight(flight_id,flight_name, source, destination, date, arrivaltime, departuretime, price, no_of_seats);
        return i;
    }
    public static int deleteFlight(int flight_id){
         int i=0;
         MFLight flight=new MFLight();
         i=flight.deleteFlight(flight_id);
             
         
         return i;
    }
    public static ResultSet getFlightById(int flight_id)
    {
        MFLight flight = new MFLight();
        ResultSet rs = flight.getFlightById(flight_id);
        return rs;
    }
    
    public static ResultSet getFlight()
    {
        MFLight flight = new MFLight();
        ResultSet rs = flight.getFlight();
        return rs;
    }
    
    public static int getMaxId()
    {
       MFLight flight = new MFLight();
       int id = flight.getMaxId();
       return id;
    }
    
    public static ResultSet getFlightBySource(String source)
    {
         MFLight flight = new MFLight();
        ResultSet rs = flight.getFlightBySource(source);
        return rs;
    }
     public static ResultSet getFlightByDestiantion(String desitination)
    {
         MFLight flight = new MFLight();
        ResultSet rs = flight.getFlightByDestination(desitination);
        return rs;
    }
     public  static ResultSet getFlightBySourceAndDestination(String source, String destination)
     {
          MFLight flight = new MFLight();
        ResultSet rs = flight.getFlightBySourceAndDestination(source, destination);
        return rs;
     }
}

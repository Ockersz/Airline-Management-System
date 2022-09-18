/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import model.MCustomer;

/**
 *
 * @author Ockersz
 */
public class CCustomer {
    
    public static int registerCustomer(String fname,String lname,String tp,String nic,String email)
    {
        int i;
        MCustomer customer = new MCustomer();
        i = customer.registerCustomer(fname, lname, tp, nic, email);
        return i;
    }
    public static int getMaxId()
    {
        int id= 0 ;
        MCustomer customer = new MCustomer();
        id = customer.getMaxId();
        return id;
    }
    public static ResultSet getCustomerByContact(String contact)
    {
        MCustomer customer = new MCustomer();
        ResultSet rs = customer.getCustomerByContact(contact);
        return rs;
    }
    
    public static int updateCustomer(String fname,String lname,String tp,String nic,String email,String existTp)
    {
        int i;
        MCustomer customer = new MCustomer();
        i = customer.updateCustomer(fname, lname, tp, nic, email, existTp);
        return i;
    }
    
}

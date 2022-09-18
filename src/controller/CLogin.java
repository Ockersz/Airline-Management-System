/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MLogin;
import java.util.Date;

/**
 *
 * @author Ockersz
 */
public class CLogin {
    
    public static boolean submitLoginDetails(String username,String password)
    {
        MLogin login = new MLogin();
        boolean i = login.submitLoginDetails(username, password);
        return i ;
    }
    
    public static String checkUsernameExist(String username)
    {
        MLogin login = new MLogin();
        String uname = login.checkUsernameExist(username);
        return uname;
    }
    
    public static int getMaxId()
    {
        MLogin login = new MLogin();
       int i = login.getMaxId();
       return i;
    }
    
    public static int registerEmployee(String fname,String lname,String tp,String address,String gender,String email,String username,String password)
    {
       
        MLogin login = new MLogin();
        int i = login.registerEmployee(fname,lname,tp,address,gender,email);
        login.insertIntoEmpCred(username, password);
        return i;
    }
    
    public static int getEmpNumber(String username)
    {
        MLogin login = new MLogin();
        int i = login.getEmpNumber(username);
        return i;
    }

    
}

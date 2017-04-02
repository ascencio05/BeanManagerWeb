/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.controles;
import java.sql.*;
import java.sql.DriverManager;
/**
 *
 * @author ascencio
 */
public class Bdd {
    public Connection con;
    public Bdd()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con =DriverManager.getConnection("jdbc:mysql://52.37.202.53:3306/BeanManager","beanmanager","CG7Tr9LqpmRCwEne");  
        }
        catch(Exception e)
        {
            System.out.println("ERROR_ "+e);     
        }
    }
    public void close()
    {
        try
        {
             con.close();
        }
        catch(Exception e)
        {
             System.out.println("ERROR_ "+e);
        }
    }
}
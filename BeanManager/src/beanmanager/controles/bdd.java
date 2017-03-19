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
public class bdd {
    public Connection con;
    public bdd()
    {
       
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con =DriverManager.getConnection("jdbc:mysql://sql112.eshost.com.ar/eshos_19849355_beanmanager","eshos_19849355","Bean2017");  
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

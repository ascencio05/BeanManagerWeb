/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.controles;
import java.sql.*;
import java.sql.DriverManager;
import java.util.List;
/**
 *
 * @author ascencio
 */
public class Bdd {
    public Connection con;
    public PreparedStatement preparedStatement;
    
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
    
    public Bdd(String unconnected)
    {
    }
    
    private Connection conectar() throws Exception
    {
        if(con == null || con.isClosed()){
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://52.37.202.53:3306/BeanManager", "beanmanager", "CG7Tr9LqpmRCwEne");
        }
        return con;
    }
    
    public void setPreparedQuery(String cmd) throws  Exception
    {
        con = conectar();
        preparedStatement = con.prepareStatement(cmd);
    }
    
    public void executeQuery(List<Object> parametrosList) throws Exception
    {
        if(parametrosList != null && parametrosList.size() >0)
        {
            for (int i = 0; i < parametrosList.size(); i++) {
                preparedStatement.setObject((i+1), parametrosList.get(i));
            }
            preparedStatement.executeUpdate();
        }
        disconnect();
    }
    
    public void disconnect() throws Exception
    {
        con.close();
    }
    
    public ResultSet executeReader(List<Object> parametrosList) throws Exception
    {
        if(parametrosList != null && parametrosList.size() >0)
        {
            for (int i = 0; i < parametrosList.size(); i++) {
                preparedStatement.setObject((i+1), parametrosList.get(i));
            }
            preparedStatement.executeUpdate();
        }
        ResultSet rs = preparedStatement.executeQuery();
        return rs;
    }
    
    public String executeUpdateLastId(List<Object> parametrosList) throws Exception
    {
        for (int i = 0; i < parametrosList.size(); i++) {
            preparedStatement.setObject((i+1), parametrosList.get(i));
        }
        preparedStatement.executeUpdate();
        preparedStatement = con.prepareStatement("SELECT LAST_INSERT_ID()");
        ResultSet rs = preparedStatement.executeQuery();
        
        rs.next();
        String lastId = rs.getString(1);
        return lastId;
    }
    
}
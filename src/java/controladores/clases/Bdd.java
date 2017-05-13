/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.clases;
import java.sql.*;
import java.sql.DriverManager;
import java.util.List;
import javax.naming.Context;
import javax.sql.DataSource;
/**
 *
 * @author ascencio
 */
public class Bdd {
    public Connection con;
    public DataSource ds;
    private PreparedStatement preparedStatement;
    private CallableStatement callableStatement;
    
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
    
    
    public CallableStatement getCallable()
    {
        return this.callableStatement;
    }
    
    public Bdd(Context initContext, String ref) throws Exception
    {
       Context env = (Context)initContext.lookup("java:comp/env");
       ds = (DataSource)env.lookup(ref);
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
    
    public void setCallableQuery(String cmd) throws Exception
    {
        con = conectar();
        callableStatement = con.prepareCall(cmd);
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
        try {
            preparedStatement.close();
            callableStatement.close();
        } catch (Exception e) {
        }
    }
    
    public ResultSet executeReader(List<Object> parametrosList) throws Exception
    {
        if(parametrosList != null && parametrosList.size() >0)
        {
            for (int i = 0; i < parametrosList.size(); i++) {
                preparedStatement.setObject((i+1), parametrosList.get(i));
            }
            
        }
        
        return preparedStatement.executeQuery();
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
        disconnect();
        return lastId;
    }
    
    public ResultSet executeCallRead(List<Object> parametrosList) throws Exception
    {
        if(parametrosList != null && parametrosList.size() >0)
        {
            for (int i = 0; i < parametrosList.size(); i++) {
                callableStatement.setObject((i+1), parametrosList.get(i));
            }
            callableStatement.executeQuery();
        }
        return callableStatement.executeQuery();
    }
    
    public void executeCall(List<Object> parametrosList) throws Exception
    {
        if(parametrosList != null && parametrosList.size() >0)
        {
            for (int i = 0; i < parametrosList.size(); i++) {
                callableStatement.setObject((i+1), parametrosList.get(i));
            }
            callableStatement.executeUpdate();
        }
        disconnect();
    }
    
    public void executeCall(List<Object> parametrosList, String unclosed) throws Exception
    {
        if(parametrosList != null && parametrosList.size() >0)
        {
            for (int i = 0; i < parametrosList.size(); i++) {
                callableStatement.setObject((i+1), parametrosList.get(i));
            }
            callableStatement.executeUpdate();
        }
    }
    
}
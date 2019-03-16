/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanetFood.Dao;

import PlanetFood.Pojo.Employees;
import PlanetFood.dbutil.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class EmployeesDao
{
    public static  boolean addEmployee(Employees e)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into employees values(?,?,?,?)");
        ps.setString(1,e.getEmpno());
        ps.setString(2,e.getEname());
        ps.setString(3,e.getJob());
        ps.setDouble(4,e.getSal());
        int count=ps.executeUpdate();
        if(count==0)
            return false;
        else
            return true;
    
    
}
    public static ArrayList<Employees> getAllEmployee()throws SQLException
    {
       ArrayList<Employees> empList=new ArrayList<>();
       Connection conn=DBConnection.getConnection();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery("select * from employees");
       while(rs.next())
       {
           Employees e=new Employees();
           e.setEmpno(rs.getString(1));
           e.setEname(rs.getString(2));
           e.setJob(rs.getString(3));
           e.setSal(rs.getDouble(4));
           empList.add(e);
       }
       return empList;
}
     public static  boolean updateEmployee(Employees e) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update employees set ename=? ,job=?,sal=? where empid=?");
        
        ps.setString(1,e.getEname());
        
        ps.setString(2,e.getJob());
        ps.setDouble(3,e.getSal());
        ps.setString(4,e.getEmpno());
        int count=ps.executeUpdate();
        if(count==0)
            return false;
        else
            return true;

     
    } 
     public static  boolean deleteEmployee(Employees e) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("delete from  employees  where empid=?");
        ps.setString(1,e.getEmpno());
        int count=ps.executeUpdate();
        if(count==0)
            return false;
        else
            return true;

    }
     public static HashMap<String,String> getAllEmployeeId()throws SQLException
    {
       HashMap<String,String> empList=new HashMap<>();
       Connection conn=DBConnection.getConnection();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery("select * from employees");
       while(rs.next())
       {
           Employees e=new Employees();
           e.setEmpno(rs.getString(1));
           e.setEname(rs.getString(2));
           e.setJob(rs.getString(3));
           e.setSal(rs.getDouble(4));
           empList.put(e.getEmpno(), e.getJob());
         
       }
       return empList;
     
    
}
     public static String getNewEmployeesId()throws SQLException
     {
        Connection   conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select count(*) from employees");
       int id=101;
      while(rs.next())
      {
          id=id+rs.getInt(1);
      }
      return "E"+id;
     }
     
     public static ArrayList<Employees> searchEmployee(String eno)throws SQLException
    {
       ArrayList<Employees> empList=new ArrayList<>();
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select * from employees where empid=?");
       ps.setString(1, eno);
       ResultSet rs=ps.executeQuery();
       while(rs.next())
       {
           Employees e=new Employees();
           e.setEmpno(rs.getString(1));
           e.setEname(rs.getString(2));
           e.setJob(rs.getString(3));
           e.setSal(rs.getDouble(4));
           empList.add(e);
       }
       return empList;

   
}
}
     


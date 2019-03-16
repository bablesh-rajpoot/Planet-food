/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanetFood.Dao;

import PlanetFood.Pojo.Employees;
import PlanetFood.Pojo.User;
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
public class UserDao
{
    ArrayList<Employees>empList;
    public static String validateUser(User user)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="select username from users where userid=? and password=? and userType=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,user.getUserid());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
        ResultSet rs=ps.executeQuery();
        
        String username=null;
        while(rs.next())
        {
            username=rs.getString(1);
        }
        return username;
          
    }
    public static HashMap<String,String> getAllUser() throws SQLException
    {
      Connection conn=DBConnection.getConnection();
      Statement st=conn.createStatement();
      ResultSet rs=st.executeQuery("select * from users");
      HashMap<String,String>userList=new HashMap<>();
      while(rs.next())
      {
         userList.put(rs.getString(4),rs.getString(5));
         
      }
      return userList;
    }
    public static boolean registerCashier(User user)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="insert into users values(?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,user.getUserid());
        ps.setString(2,user.getUserName());
        ps.setString(3,user.getPassword());
       ps.setString(4,user.getEmpId());
        ps.setString(5,user.getUserType());
        int x=ps.executeUpdate();
        if(x>0)
            return true;
        else
            return false;
    }
    public static ArrayList<User> searchCashier(String uid)throws SQLException
    {
      Connection conn=DBConnection.getConnection();
      String qry="select userid,username,empid from users where userid=?";
      PreparedStatement ps=conn.prepareStatement(qry);
      ArrayList<User>userList=new ArrayList<User>();
      ps.setString(1,uid);
      ResultSet rs=ps.executeQuery();
      while(rs.next())
      { 
         User u=new User();
         u.setUserid(rs.getString(1));
         u.setUserName(rs.getString(2));
        u.setEmpId(rs.getString(3));
         userList.add(u);
     }
      return userList;
      
  }
    public static boolean removecashier(String ud)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="delete from users where userid=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,ud);
        int x=ps.executeUpdate();
        if(x>0)
          return true;
        else
           return false;
    }
     
}

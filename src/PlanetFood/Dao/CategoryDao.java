/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanetFood.Dao;

import PlanetFood.Pojo.Category;
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
public class CategoryDao
{
    public static HashMap<String,String>getAllCategoryId()throws SQLException
    {
      Connection conn=DBConnection.getConnection();
      Statement st=conn.createStatement();
      ResultSet rs=st.executeQuery("select * from Categories");
      HashMap<String,String>categories=new HashMap<>();
      while(rs.next())
      {
         String catId=rs.getString(1);
         String catName=rs.getString(2);
         categories.put(catName,catId);
      }
      return categories; 
      
}
    public static String getNewCatId()throws SQLException
    {
      Connection   conn=DBConnection.getConnection();
      Statement st=conn.createStatement();
      ResultSet rs=st.executeQuery("select count(*) from categories");
      int id=101;
      while(rs.next())
      {
          id=id+rs.getInt(1);
      }
      return "C"+id;
    }
    public static boolean addcategories(Category c)throws SQLException
    {
      Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("insert into categories values(?,?)");
        ps.setString(1,c.getCatId());
        ps.setString(2,c.getCatName());  
        int x=ps.executeUpdate();
        if(x==0)
            return false;
        else
            return true;
    }
    public static  ArrayList<Category>getAlldata()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="select * from categories";
        Statement st=conn.createStatement();
        ArrayList<Category>catList=new ArrayList<>();
        ResultSet rs=st.executeQuery(qry);
        while(rs.next())
        {
        Category p=new Category();
        p.setCatId(rs.getString(1));
        p.setCatName(rs.getString(2));
        catList.add(p);
      }
        return catList;
                
}
     public static boolean updateCategory(Category p)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="update  categories  set cat_name=? where CAT_Id=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,p.getCatName());
        ps.setString(2,p.getCatId());
        int x=ps.executeUpdate();
        if(x==0)
            return false;
        else
            return true;
 }
     
      public static HashMap<String,String>getAllCategoriesId(String str)throws SQLException
    {
      Connection conn=DBConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("select * from Categories where cat_name=?");
      ps.setString(1, str);
      ResultSet rs=ps.executeQuery();
      HashMap<String,String>categories=new HashMap<>();
      while(rs.next())
      {
         String catId=rs.getString(1);
         String catName=rs.getString(2);
         categories.put(catName,catId);
      }
      return categories; 
}
      public static boolean removecategories(String ss)throws SQLException
    {
      Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("delete from categories where cat_name= ?");
       ps.setString(1,ss);
      int x=ps.executeUpdate();
        if(x==0)
            return false;
        else
            return true;
    }
}

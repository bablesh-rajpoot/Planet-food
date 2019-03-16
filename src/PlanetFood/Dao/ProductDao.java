/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanetFood.Dao;

import PlanetFood.Pojo.Product;
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
public class ProductDao
{ 
    public static String getNewId()throws SQLException 
{
    Connection conn=DBConnection.getConnection();
      Statement st=conn.createStatement();
      int id=101;
      ResultSet rs=st.executeQuery("select count(*) from products");
      if(rs.next())
      {
          id=id+rs.getInt(1);
      }
      return "P"+id;
      
 
}
    public static boolean addProduct(Product p)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into products values(?,?,?,?,?)");
        ps.setString(1,p.getProdId());
        ps.setString(2,p.getCatId());
        ps.setString(3,p.getProdName());
        ps.setDouble(4,p.getProdPrice());
        ps.setString(5,p.getIsActive());
        int count=ps.executeUpdate();
        if(count==0)
            return false;
        else
            return true;
    }
    public static HashMap<String,Product>getProducatId(String catId)throws Exception
    {
        Connection conn=DBConnection.getConnection();
        String qry="select * from products where CAT_ID=? and active='Y' ";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,catId);
        HashMap<String,Product>productList=new HashMap<>();
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        Product p=new Product();
        p.setCatId(rs.getString(2));
        p.setProdId(rs.getString(1));
        p.setProdName(rs.getString(3));
        p.setProdPrice(rs.getDouble(4));
        p.setIsActive(rs.getString(5));
        productList.put(p.getProdId(),p );
        
       }
        return productList;
                
                
        
    }
    public static ArrayList<Product>getAlldata()throws SQLException
    
    
  {
        Connection conn=DBConnection.getConnection();
        String qry="select * from products ";
        Statement st=conn.createStatement();
        ArrayList<Product>productList=new ArrayList<>();
        ResultSet rs=st.executeQuery(qry);
        while(rs.next())
        {
        Product p=new Product();
       
        p.setProdId(rs.getString(1));
        p.setCatId(rs.getString(2));
        p.setProdName(rs.getString(3));
        p.setProdPrice(rs.getDouble(4));
        p.setIsActive(rs.getString(5));
        productList.add(p);
        
        
       }
        return productList;
                
    }
    public static boolean updateProduct(Product p)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="update  products  set prod_name=?,prod_price=?,active=? where PROD_Id=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        
        ps.setString(1,p.getProdName());
        ps.setDouble(2,p.getProdPrice());
        ps.setString(3,p.getIsActive());
        ps.setString(4,p.getProdId());
        int x=ps.executeUpdate();
        if(x>0)
            return true;
        else
            return false;
 }
    

 public static boolean removeProduct(String s)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="update  products  set active='N' where PROD_NAME=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,s);
        int x=ps.executeUpdate();
        if(x>0)
            return true;
        else
            return false;
 }

 public static ArrayList<Product>getallProduct(String catId)throws Exception
    {
        Connection conn=DBConnection.getConnection();
        String qry="select * from products where CAT_ID=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,catId);
        ArrayList<Product>productList=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        Product p=new Product();
        p.setCatId(rs.getString(2));
        p.setProdId(rs.getString(1));
        p.setProdName(rs.getString(3));
        p.setProdPrice(rs.getDouble(4));
        p.setIsActive(rs.getString(5));
        productList.add(p);
        
       }
        return productList;
                
                
    }
 
public static ArrayList<Product>removeAlldata()throws SQLException
    
    
  {
        Connection conn=DBConnection.getConnection();
        String qry="select * from products where active ='Y' ";
        Statement st=conn.createStatement();
        ArrayList<Product>productList=new ArrayList<>();
        ResultSet rs=st.executeQuery(qry);
        while(rs.next())
        {
        Product p=new Product();
       
        p.setProdId(rs.getString(1));
        p.setCatId(rs.getString(2));
        p.setProdName(rs.getString(3));
        p.setProdPrice(rs.getDouble(4));
        p.setIsActive(rs.getString(5));
        productList.add(p);
        
        
       }
        return productList;
  }
}

















   
    


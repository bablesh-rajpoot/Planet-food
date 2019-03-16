/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanetFood.Dao;

import PlanetFood.Pojo.OrderDetail;
import PlanetFood.Pojo.Orders;
import PlanetFood.dbutil.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class OrdersDao 
{
    
    public static ArrayList<Orders>getordersBYdate(Date startDate,Date endDate)throws SQLException
    {
  
      Connection conn=DBConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("select * from orders where ( ord_date between ? and ?) ");
      long ms1=startDate.getTime();
      long ms2=endDate.getTime();
      
      java.sql.Date d1=new java.sql.Date(ms1);
      java.sql.Date d2=new java.sql.Date(ms2);
      
      
      ps.setDate(1,d1);
      ps.setDate(2,d2);
      ArrayList<Orders>ordList=new ArrayList<Orders>();
      ResultSet rs=ps.executeQuery();
      
       while(rs.next())
       {
           Orders o=new Orders();
          o.setOrdId(rs.getString(1));
           
           java.sql.Date d=rs.getDate(2);
           
           SimpleDateFormat sdf=new  SimpleDateFormat("dd-MMM-yyyy");
           String datestr=sdf.format(d);
           o.setOrddate(datestr);
       
           o.setGst(rs.getDouble(3));
           o.setGstamount(rs.getDouble(4));
           o.setGrandtotal(rs.getDouble(5));
           o.setDiscount(rs.getDouble(6));
           o.setUserId(rs.getString(7));
           o.setOrdamount(rs.getDouble(8));
           ordList.add(o);
       }
       
       return ordList;       
    }
    public static ArrayList<Orders>getAllOrdersDetials()throws SQLException
    {
       Connection conn=DBConnection.getConnection();
      Statement st=conn.createStatement();
      ArrayList<Orders>ordList=new ArrayList<>();
      ResultSet  rs=st.executeQuery("select * from orders");
       while(rs.next())
       {
           Orders o=new Orders();
          o.setOrdId(rs.getString(1));
           
           java.sql.Date d=rs.getDate("ord_date");
           
           SimpleDateFormat sdf=new  SimpleDateFormat("dd-MMM-yyyy");
           String datestr=sdf.format(d);
           o.setOrddate(datestr);
       
           o.setGst(rs.getDouble(3));
           o.setGstamount(rs.getDouble(4));
           o.setGrandtotal(rs.getDouble(5));
           o.setDiscount(rs.getDouble(6));
           o.setUserId(rs.getString(7));
           o.setOrdamount(rs.getDouble(8));
           
           
           ordList.add(o);
       }
       
       return ordList;         
    }
      public static String getNewId()throws SQLException 
      {
          
      Connection conn=DBConnection.getConnection();
      Statement st=conn.createStatement();
      int id=101;
      ResultSet rs=st.executeQuery("select count(*) from orders");
      if(rs.next())
      {
          id=id+rs.getInt(1);
      }
      return "OD"+id;
      
 
}
      
  public static boolean addOrders(Orders order) throws SQLException,ParseException
  {
    Connection conn=DBConnection.getConnection();
    String qry="insert into orders values(?,?,?,?,?,?,?,?)";
    PreparedStatement ps=conn.prepareStatement(qry);
    ps.setString(1,order.getOrdId());
    String str=order.getOrddate();
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
    //java.util.Date d1=sdf.parse(str);
    //java.sql.Date d2=new java.sql.Date(d1.getTime());
    long millis=System.currentTimeMillis();  
    java.sql.Date date=new java.sql.Date(millis);   
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");   
    System.out.println(formatter.format(date));  
    ps.setDate(2,date);
    ps.setDouble(3,order.getGst());
    ps.setDouble(4,order.getGstamount());
    ps.setDouble(5,order.getGrandtotal());
    ps.setDouble(6,order.getDiscount());
    ps.setString(7, order.getUserId());
    ps.setDouble(8,order.getOrdamount());
    int x=ps.executeUpdate();
   if(x>0)
    return true;
     else
         return 
                 false;
             
    
  }
  public static boolean addOrder(Orders order,ArrayList<OrderDetail>ordList) throws SQLException,ParseException
  {
    Connection conn=DBConnection.getConnection();
    String qry="insert into orders values(?,?,?,?,?,?,?,?)";
    PreparedStatement ps=conn.prepareStatement(qry);
    ps.setString(1,order.getOrdId());
    String str=order.getOrddate();
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
    //java.util.Date d1=sdf.parse(str);
    //java.sql.Date d2=new java.sql.Date(d1.getTime());
    long millis=System.currentTimeMillis();  
    java.sql.Date date=new java.sql.Date(millis);   
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");   
    System.out.println(formatter.format(date));  
    ps.setDate(2,date);
    ps.setDouble(3,order.getGst());
    ps.setDouble(4,order.getGstamount());
    ps.setDouble(5,order.getGrandtotal());
    ps.setDouble(6,order.getDiscount());
    ps.setString(7, order.getUserId());
    ps.setDouble(8,order.getOrdamount());
    int x=ps.executeUpdate();
    
    PreparedStatement ps2=conn.prepareStatement("insert into order_details values(?,?,?,?)");
    int count=0;
    for(OrderDetail od:ordList)
    {
      ps2.setString(1,od.getOrdId());
      ps2.setString(2,od.getProdId());
      ps2.setDouble(3,od.getQuantity());
      ps2.setDouble(4,od.getCost());
     int y=ps2.executeUpdate();
     if(y>0)
     count=count+y;
    }
    if(x>0 && count==ordList.size())
    return true;
     else
         return 
                 false;
    
   
}
  
  public static boolean CancelOrder(Orders order,OrderDetail od) throws SQLException,ParseException
  {
    Connection conn=DBConnection.getConnection();
    String qry="delete from orders where ord_id=? ";
    PreparedStatement ps=conn.prepareStatement(qry);
    ps.setString(1,order.getOrdId());
    int x=ps.executeUpdate();
    
    PreparedStatement ps2=conn.prepareStatement("delete from order_details where ord_id=? ");
     int count=0;
     ps2.setString(1,od.getOrdId());
     int y=ps2.executeUpdate();
     if(y>0)
     count=count+y;
    
    if(x>0 && count>0)
    return true;
     else
         return 
                 false;
    
   
}
}

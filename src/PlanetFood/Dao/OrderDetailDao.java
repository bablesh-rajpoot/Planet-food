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
import java.util.ArrayList;

/**
 *
 * @author BABLESH RAJPOOT
 */
public class OrderDetailDao 
{
  public static boolean addOrderDetail(OrderDetail od)throws SQLException
  {
      Connection conn=DBConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("insert into order_details values(?,?,?,?)");
      ps.setString(1,od.getOrdId());
      ps.setString(2,od.getProdId());
      ps.setDouble(3,od.getQuantity());
      ps.setDouble(4,od.getCost());
     int x=ps.executeUpdate();
          if(x==0)
          return false;
          else
             return true;
 }
    public static ArrayList<OrderDetail>getAlldata()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="select * from order_details";
        Statement st=conn.createStatement();
        ArrayList<OrderDetail>ordList=new ArrayList<>();
        ResultSet rs=st.executeQuery(qry);
        while(rs.next())
        {
        OrderDetail odd=new OrderDetail ();
        odd.setOrdId(rs.getString(1));
        odd.setProdId(rs.getString(2));
        odd.setQuantity(rs.getDouble(3));
        odd.setCost(rs.getDouble(4));
         ordList.add(odd);
       }
        return ordList;
                
}
    public static String getNewId()throws SQLException 
      {
      Connection conn=DBConnection.getConnection();
      Statement st=conn.createStatement();
      int id=101;
      ResultSet rs=st.executeQuery("select count(*) from order_details");
      if(rs.next())
      {
          id=id+rs.getInt(1);
      }
      return "ORD"+id;
}
}

   

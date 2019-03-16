/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanetFood.Pojo;

/**
 *
 * @author ASUS
 */
public class Orders
{
   private String ordId;
   private String orddate; 
   private double gst; 
   private double gstamount; 
   private double discount; 
   private double grandtotal; 
   private String userId; 
   private double ordamount; 

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public void setOrddate(String orddate) {
        this.orddate = orddate;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public void setGstamount(double gstamount) {
        this.gstamount = gstamount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setGrandtotal(double grandtotal) {
        this.grandtotal = grandtotal;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public String getOrdId() {
        return ordId;
    }

    public String getOrddate() {
        return orddate;
    }

    public double getGst() {
        return gst;
    }

    public double getGstamount() {
        return gstamount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getGrandtotal() {
        return grandtotal;
    }

    public String getUserId() {
        return userId;
    }

    public double getOrdamount() {
        return ordamount;
    }
   
}

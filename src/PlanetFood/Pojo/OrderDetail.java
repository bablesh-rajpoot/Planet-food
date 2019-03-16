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
public class OrderDetail 
{
    private String ordId;
    private String prodId;
    private double quantity;
    private double cost;

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getOrdId() {
        return ordId;
    }

    public String getProdId() {
        return prodId;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }
    
}

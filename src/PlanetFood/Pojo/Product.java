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
public class Product {
    private String prodId;
    private String catId;
    private String prodName;
    private double prodPrice;
    private String isActive;

    public String getProdId() {
        return prodId;
    }

    public String getCatId() {
        return catId;
    }

    public String getProdName() {
        return prodName;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
    
        
    
}

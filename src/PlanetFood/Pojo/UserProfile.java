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
public class UserProfile {
     private static String username;
     private  static String usertype;
     private static String userId;

    public static void setUsertype(String usertype) {
        UserProfile.usertype = usertype;
    }

    public static void setUserId(String userId) {
        UserProfile.userId = userId;
    }

    public static String getUsertype() {
        return usertype;
    }

    public static String getUserId() {
        return userId;
    }

    public static String getUsername() {
        return username;
    }

    public static String getUserType() {
        return usertype;
    }

    public static void setUsername(String username) {
        UserProfile.username = username;
    }

    public static void setUserType(String userType) {
        UserProfile.usertype = userType;
    }
    
     
    
}

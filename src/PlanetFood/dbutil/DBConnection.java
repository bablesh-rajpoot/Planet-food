
package PlanetFood.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DBConnection 
{  
    
    private static Connection conn;
    static
    {
        try
        {
          Class.forName("oracle.jdbc.OracleDriver");
          conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","planetfood","planetfood");
          JOptionPane.showMessageDialog(null,"Connection successs to the datebase","Successs!",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException ex)
        {
           JOptionPane.showMessageDialog(null,"Error loadind Driver class"+ex,"Error",JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
        }
        catch(SQLException sql)
        {
            JOptionPane.showMessageDialog(null,"Error in Db"+sql,"Error",JOptionPane.ERROR_MESSAGE);
           sql.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    
    public static void closeConnection()
    {
        try
        {
            conn.close();
        }
        catch(SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"Error in close Connection"+ex,"Error",JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace(); 
        }
            
    }
    
}

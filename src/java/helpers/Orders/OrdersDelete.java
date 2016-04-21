/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.Orders;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KsS
 */
public class OrdersDelete {
    
     private Connection conn;
     
     public OrdersDelete(){
         
          Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr= this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");
        
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(OrdersDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(OrdersDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver=props.getProperty("driver.name");
        String url=props.getProperty("server.name");
        String username=props.getProperty("user.name");
        String password=props.getProperty("user.password");
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrdersDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn=DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void doDelete(int order_id){
        
        try {
            String query="DELETE from orders where order_id = ?";
            PreparedStatement ps= conn.prepareStatement(query);
            
            ps.setInt(1, order_id);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
}

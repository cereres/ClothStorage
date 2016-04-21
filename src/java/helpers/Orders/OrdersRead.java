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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Orders;


/**
 *
 * @author KsS
 */
public class OrdersRead {
    
    private Connection conn;
    private ResultSet results;
    
    public OrdersRead(){
        
        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr= this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");
        
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(OrdersRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(OrdersRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver=props.getProperty("driver.name");
        String url=props.getProperty("server.name");
        String username=props.getProperty("user.name");
        String password=props.getProperty("user.password");
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrdersRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn=DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(OrdersRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void doRead(){
            
        try {
            String query="Select * from Orders";
            
            PreparedStatement ps=conn.prepareStatement(query);
            this.results=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(OrdersRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
     
     public String getHTMLTable(){
         String table="";
         table+="<table border=1>";
          table+="<tr>";
                table+="<td>";
                table+="Order ID";
                table+="</td>";
                
                table+="<td>";
                table+="Customer ID";
                table+="</td>";
                
              
                
                table+="<td>";
                table+="Total Sum";
                table+="</td>";
                
                                
                table+="<td>";
                table+="Modification";
                table+="</td>";
                 table+="</tr>";
         
        try {
            while(this.results.next())
            {
                Orders order= new Orders();
                order.setOrder_id(this.results.getInt("Order_id"));
                order.setCustomer_id(this.results.getInt("Customer_id"));
                order.setTotal_sum(this.results.getInt("Total_sum"));
                
                
                
                table+="<tr>";
                table+="<td>";
                table+=order.getOrder_id();
                table+="</td>";
               
                
               
                table+="<td>";
                table+=order.getCustomer_id();
                table+="</td>";
                
                   
             
                table+="<td>";
                table+=order.getTotal_sum();
                table+="</td>";
                
                
                
                table+="<td>";
                table+="<a href=update?order_id="+order.getOrder_id()+"> Update </a>"+"<a href=delete?order_id="+order.getOrder_id()+"> Delete </a>";
                table+="</td>";
                
                
                table+="</tr>";
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersRead.class.getName()).log(Level.SEVERE, null, ex);
        }
         table+="</table>";
         
         return table;
     }
    
}

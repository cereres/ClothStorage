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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Orders;


/**
 *
 * @author KsS
 */
public class OrdersAdd {
    
    private Connection conn;
    private ResultSet results;
    
    public OrdersAdd(){
        
        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr= this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");
        
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(OrdersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(OrdersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver=props.getProperty("driver.name");
        String url=props.getProperty("server.name");
        String username=props.getProperty("user.name");
        String password=props.getProperty("user.password");
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrdersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn=DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(OrdersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void doAdd(Orders order) {

        int counter = 0;
        counter = chooseID();
        order.setOrder_id(counter);

        try {
            String query = "Insert INTO Orders(order_id, customer_id, total_sum) VALUES (?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, order.getOrder_id());
            ps.setInt(2, order.getCustomer_id());
            ps.setInt(3, order.getTotal_sum());
            

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrdersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   

    public int chooseID() {
        int max=0;
        try {
            
            String query1 = "Select * from Orders";
            
            PreparedStatement ps = conn.prepareStatement(query1);
            this.results = ps.executeQuery();
            
            while (this.results.next()){
                Orders order= new Orders();
                order.setOrder_id(this.results.getInt("Order_id"));
                int temp=order.getOrder_id();
                if(temp>max) max=temp;
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OrdersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (max+1);
    }
    
    public List findID(){
          
        List <Integer> list= new ArrayList<Integer>();
        try {
           
            String query2 = "Select * from Orders";
            PreparedStatement ps = conn.prepareStatement(query2);
            this.results = ps.executeQuery();
            while (this.results.next()) {
                Orders order = new Orders();
                order.setOrder_id(this.results.getInt("Order_id"));
                list.add(order.getOrder_id());
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OrdersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
     }
    
}

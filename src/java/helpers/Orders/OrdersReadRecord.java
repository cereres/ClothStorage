/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.Orders;


import java.io.IOException;
import java.io.InputStream;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import model.Orders;




/**
 *
 * @author KsS
 */
public class OrdersReadRecord {
    
    private Connection conn;
    private ResultSet results;

    private Orders order = new Orders();
    private int order_id;
    
    public OrdersReadRecord(int order_id){
        
        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr= this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");
        
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(OrdersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(OrdersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver=props.getProperty("driver.name");
        String url=props.getProperty("server.name");
        String username=props.getProperty("user.name");
        String password=props.getProperty("user.password");
        
        this.order_id=order_id;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrdersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn=DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(OrdersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void doRead() {

        try {
            String query = "Select * from Orders where order_id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, order_id);

            this.results = ps.executeQuery();
            this.results.next();

            order.setOrder_id(this.results.getInt("Order_id"));
            order.setCustomer_id(this.results.getInt("Customer_id"));
            order.setTotal_sum(this.results.getInt("Total_sum"));
            
        } catch (SQLException ex) {
            Logger.getLogger(OrdersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Orders getOrder(){
        
        return this.order;
    }
    
}

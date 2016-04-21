/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.Order_Items;

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
import model.Order_Items;

/**
 *
 * @author KsS
 */
public class ItemsReadRecord {
    
    private Connection conn;
    private ResultSet results;

    private Order_Items item = new Order_Items();
    private int item_id;
    
    public ItemsReadRecord(int item_id){
        
        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr = this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");

        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ItemsReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ItemsReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");
        this.item_id=item_id;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemsReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ItemsReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead() {

        try {
            String query = "Select * from Order_Items where order_items_id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, item_id);

            this.results = ps.executeQuery();
            this.results.next();
            item.setOrder_items_id(this.results.getInt("Order_items_id"));
            item.setOrder_id(this.results.getInt("Order_id"));
            item.setProduct_id(this.results.getInt("Product_id"));
            item.setQuantity(this.results.getInt("Quantity"));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemsReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Order_Items getItem(){
        
        return this.item;
    }
    
    
}

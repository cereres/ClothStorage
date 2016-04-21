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
public class ItemsAdd {
    
    private Connection conn;
    private ResultSet results;
    
    public ItemsAdd(){
        
        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr = this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");

        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ItemsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ItemsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ItemsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doAdd(Order_Items item) {

        int counter = 0;
        counter = chooseID();
        item.setOrder_items_id(counter);

        try {
            String query = "Insert INTO Order_Items(order_items_id, order_id, product_id, quantity) VALUES (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, item.getOrder_items_id());
            ps.setInt(2, item.getOrder_id());
            ps.setInt(3, item.getProduct_id());
            ps.setInt(4, item.getQuantity());
            

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ItemsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int chooseID() {
        int max=0;
        try {
            
            String query1 = "Select * from Order_Items";
            
            PreparedStatement ps = conn.prepareStatement(query1);
            this.results = ps.executeQuery();
            
            while (this.results.next()){
                Order_Items item= new Order_Items();
                item.setOrder_items_id(this.results.getInt("Order_items_id"));
                int temp=item.getOrder_items_id();
                if(temp>max) max=temp;
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (max+1);
    }

    
}

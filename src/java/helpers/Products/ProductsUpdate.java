/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.Products;



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
import model.Products;


/**
 *
 * @author KsS
 */
public class ProductsUpdate {
    
     private Connection conn;
     
     public ProductsUpdate(){
         Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr= this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");
        
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ProductsUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ProductsUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver=props.getProperty("driver.name");
        String url=props.getProperty("server.name");
        String username=props.getProperty("user.name");
        String password=props.getProperty("user.password");
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductsUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn=DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
     public void doUpdate(Products product){
        
        try {
            String query="Update Products SET product_name=?, category=?, list_price=?, product_amount=?,supplier_id=? Where product_id=?";
            
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, product.getProduct_name());
            ps.setString(2, product.getCategory());
            ps.setInt(3, product.getList_price());
            ps.setInt(4, product.getProduct_amount());
            ps.setInt(5, product.getSupplier_id());
            ps.setInt(6, product.getProduct_id());
            
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}

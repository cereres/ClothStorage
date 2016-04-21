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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Products;


/**
 *
 * @author KsS
 */
public class ProductsAdd {
    
     private Connection conn;
    private ResultSet results;
    
    public ProductsAdd(){
        
        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr = this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");

        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ProductsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ProductsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doAdd(Products product) {

        int counter = 0;
        counter = chooseID();
        product.setProduct_id(counter);

        try {
            String query = "Insert INTO Products(product_id, product_name, category, list_price, product_amount, supplier_id) VALUES (?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, product.getProduct_id());
            ps.setString(2, product.getProduct_name());
            ps.setString(3, product.getCategory());
            ps.setInt(4, product.getList_price());
            ps.setInt(5, product.getProduct_amount());
            ps.setInt(6, product.getSupplier_id());
            

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   

    public int chooseID() {
        int max=0;
        try {
            
            String query1 = "Select * from Products";
            
            PreparedStatement ps = conn.prepareStatement(query1);
            this.results = ps.executeQuery();
            
            while (this.results.next()){
                Products product= new Products();
                product.setProduct_id(this.results.getInt("Product_id"));
                int temp=product.getProduct_id();
                if(temp>max) max=temp;
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (max+1);
    }

    public List findID(){
          
        List <Integer> list= new ArrayList<Integer>();
        try {
           
            String query2 = "Select * from Products";
            PreparedStatement ps = conn.prepareStatement(query2);
            this.results = ps.executeQuery();
            while (this.results.next()) {
                Products product = new Products();
                product.setProduct_id(this.results.getInt("Product_id"));
                list.add(product.getProduct_id());
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
     }
    
    public String findProduct_name(int i){
       String prod_name="";
        try {
            String query="Select Product_name from Products where product_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, i);
            this.results = ps.executeQuery();
              this.results.next();
            Products product = new Products();
            product.setProduct_name(this.results.getString("Product_name"));
            prod_name=product.getProduct_name();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return prod_name;
        
                                    
    }
    
}

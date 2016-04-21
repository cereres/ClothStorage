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

import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Products;


/**
 *
 * @author KsS
 */
public class ProductsRead {
    
     private Connection conn;
    private ResultSet results;
    
    public ProductsRead(){
        
        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr= this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");
        
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ProductsRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ProductsRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver=props.getProperty("driver.name");
        String url=props.getProperty("server.name");
        String username=props.getProperty("user.name");
        String password=props.getProperty("user.password");
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductsRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn=DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void doRead(){
            
        try {
            String query="Select * from Products";
            
            PreparedStatement ps=conn.prepareStatement(query);
            this.results=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
     
     public String getHTMLTable(){
         String table="";
         table+="<table border=1>";
          table+="<tr>";
                table+="<td>";
                table+="Product ID";
                table+="</td>";
                
                table+="<td>";
                table+="Product name";
                table+="</td>";
                
              
                
                table+="<td>";
                table+="Category";
                table+="</td>";
                
                table+="<td>";
                table+="List Price";
                table+="</td>";
                
                table+="<td>";
                table+="Product Amount";
                table+="</td>";
                
                table+="<td>";
                table+="Supplier ID";
                table+="</td>";
                
                table+="<td>";
                table+="Modification";
                table+="</td>";
                 table+="</tr>";
         
        try {
            while(this.results.next())
            {
                Products product= new Products();
                product.setProduct_id(this.results.getInt("Product_id"));
                product.setProduct_name(this.results.getString("Product_name"));
                
                product.setCategory(this.results.getString("Category"));
                product.setList_price(results.getInt("List_price"));
                product.setProduct_amount(results.getInt("Product_amount"));
                product.setSupplier_id(results.getInt("Supplier_id"));
                
                
                table+="<tr>";
                table+="<td>";
                table+=product.getProduct_id();
                table+="</td>";
               
                
               
                table+="<td>";
                table+=product.getProduct_name();
                table+="</td>";
                
                
              
               
                
                
             
                table+="<td>";
                table+=product.getCategory();
                table+="</td>";
                
                
                
                table+="<td>";
                table+=product.getList_price();
                table+="</td>";
             
                
               
                table+="<td>";
                table+=product.getProduct_amount();
                table+="</td>";
                
                
                
                table+="<td>";
                table+=product.getSupplier_id();
                table+="</td>";
                
                table+="<td>";
                table+="<a href=update?product_id="+product.getProduct_id()+"> Update </a>"+"<a href=delete?product_id="+product.getProduct_id()+"> Delete </a>";
                table+="</td>";
                
                
                table+="</tr>";
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductsRead.class.getName()).log(Level.SEVERE, null, ex);
        }
         table+="</table>";
         
         return table;
     }
}

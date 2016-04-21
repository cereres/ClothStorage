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
public class ProductsReadRecord {

    private Connection conn;
    private ResultSet results;

    private Products product = new Products();
    private int product_id;

    public ProductsReadRecord(int product_id) {

        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr = this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");

        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ProductsReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ProductsReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");

        this.product_id = product_id;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductsReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doRead() {

        try {
            String query = "Select * from Products where product_id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, product_id);

            this.results = ps.executeQuery();
            this.results.next();

            product.setProduct_id(this.results.getInt("Product_id"));
            product.setProduct_name(this.results.getString("Product_name"));

            product.setCategory(this.results.getString("Category"));
            product.setList_price(results.getInt("List_price"));
            product.setProduct_amount(results.getInt("Product_amount"));
            product.setSupplier_id(results.getInt("Supplier_id"));
        } catch (SQLException ex) {
            Logger.getLogger(ProductsReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Products getProduct(){
        
        return this.product;
    }
}

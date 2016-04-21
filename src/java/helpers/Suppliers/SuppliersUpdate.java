/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.Suppliers;


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
import model.Suppliers;


/**
 *
 * @author KsS
 */
public class SuppliersUpdate {
    
     private Connection conn;
     
     public SuppliersUpdate(){
         
         Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr= this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");
        
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SuppliersUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SuppliersUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver=props.getProperty("driver.name");
        String url=props.getProperty("server.name");
        String username=props.getProperty("user.name");
        String password=props.getProperty("user.password");
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SuppliersUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn=DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public void doUpdate(Suppliers supplier){
        
        try {
            String query="Update Suppliers_of_products SET organization_name=?, person_in_charge=?,  adress=?, phone_number=?, email=? Where supplier_id=?";
            
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, supplier.getOrganization_name());
            ps.setString(2, supplier.getPerson_in_charge());
          
            ps.setString(3, supplier.getAdress());
            ps.setLong(4, supplier.getPhone_number());
            ps.setString(5, supplier.getEmail());
            ps.setInt(6, supplier.getSupplier_id());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}

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
import java.sql.ResultSet;
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
public class SuppliersReadRecord {

    private Connection conn;
    private ResultSet results;

    private Suppliers supplier = new Suppliers();
    private int supplier_id;
    
    public SuppliersReadRecord(int supplier_id){
        
        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr = this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");

        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SuppliersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SuppliersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");

        this.supplier_id = supplier_id;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SuppliersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead() {

        try {
            String query = "Select * from Suppliers_of_products where supplier_id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, supplier_id);
            
            this.results = ps.executeQuery();
            this.results.next();
            
            supplier.setSupplier_id(this.results.getInt("supplier_id"));
            supplier.setOrganization_name(this.results.getString("Organization_name"));
            supplier.setPerson_in_charge(this.results.getString("Person_in_charge"));
            
            supplier.setAdress(this.results.getString("Adress"));
            supplier.setPhone_number(this.results.getLong("Phone_number"));
            supplier.setEmail(this.results.getString("Email"));
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Suppliers getSupplier(){
        
        return this.supplier;
    }

}

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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Suppliers;

/**
 *
 * @author KsS
 */
public class SuppliersAdd {

    private Connection conn;
    private ResultSet results;

    public SuppliersAdd() {
        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr = this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");

        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SuppliersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SuppliersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SuppliersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doAdd(Suppliers supplier) {

        
        int counter = chooseID();
        supplier.setSupplier_id(counter);

        try {
            String query = "Insert INTO Suppliers_of_products(supplier_id, organization_name, person_in_charge,  adress, phone_number, email) VALUES (?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, supplier.getSupplier_id());
            ps.setString(2, supplier.getOrganization_name());
            ps.setString(3, supplier.getPerson_in_charge());
            ps.setString(4, supplier.getAdress());
            ps.setLong(5, supplier.getPhone_number());
            ps.setString(6, supplier.getEmail());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int chooseID() {
        int max = 0;
        try {

            String query1 = "Select * from Suppliers_of_products";

            PreparedStatement ps = conn.prepareStatement(query1);
            this.results = ps.executeQuery();

            while (this.results.next()) {
                Suppliers supplier = new Suppliers();
                supplier.setSupplier_id(this.results.getInt("Supplier_id"));
                int temp = supplier.getSupplier_id();
                if (temp > max) {
                    max = temp;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(SuppliersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (max + 1);
    }

    public List findID(){
          
        List <Integer> list= new ArrayList<Integer>();
        try {
           
            String query2 = "Select * from Suppliers_of_products";
            PreparedStatement ps = conn.prepareStatement(query2);
            this.results = ps.executeQuery();
            while (this.results.next()) {
                Suppliers supplier = new Suppliers();
                supplier.setSupplier_id(this.results.getInt("Supplier_id"));
                list.add(supplier.getSupplier_id());
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
     }
    
    public String findOrganization_name(int i){
       String org_name="";
        try {
            String query="Select Organization_name from Suppliers_of_products where supplier_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, i);
            this.results = ps.executeQuery();
              this.results.next();
            Suppliers supplier = new Suppliers();
            supplier.setOrganization_name(this.results.getString("Organization_name"));
            org_name=supplier.getOrganization_name();
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return org_name;
        
                                    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.Customers;

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
import model.Customers;

/**
 *
 * @author KsS
 */
public class CustomersReadRecord {

    private Connection conn;
    private ResultSet results;

    private Customers customer = new Customers();
    private int customer_id;

    public CustomersReadRecord(int customer_id) {

        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr = this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");

        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(CustomersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(CustomersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");

        this.customer_id = customer_id;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doRead() {

        try {
            String query = "Select * from Customers where customer_id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, customer_id);
            
            this.results = ps.executeQuery();
            this.results.next();
            
            customer.setCustomer_id(this.results.getInt("customer_id"));
            customer.setOrganization_name(this.results.getString("Organization_name"));
            customer.setPerson_in_charge(this.results.getString("Person_in_charge"));
            customer.setBank_account(results.getInt("Bank_account"));
            customer.setAdress(this.results.getString("Adress"));
            customer.setPhone_number(this.results.getLong("Phone_number"));
            customer.setEmail(this.results.getString("Email"));
        } catch (SQLException ex) {
            Logger.getLogger(CustomersReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Customers getCustomer(){
        
        return this.customer;
    }
}

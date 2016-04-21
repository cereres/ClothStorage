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
public class CustomersUpdate {
    
    private Connection conn;
    
    public CustomersUpdate(){
        
        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr= this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");
        
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(CustomersUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(CustomersUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver=props.getProperty("driver.name");
        String url=props.getProperty("server.name");
        String username=props.getProperty("user.name");
        String password=props.getProperty("user.password");
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomersUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn=DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doUpdate(Customers customer){
        
        try {
            String query="Update Customers SET organization_name=?, person_in_charge=?, bank_account=?, adress=?, phone_number=?, email=? Where customer_id=?";
            
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, customer.getOrganization_name());
            ps.setString(2, customer.getPerson_in_charge());
            ps.setInt(3, customer.getBank_account());
            ps.setString(4, customer.getAdress());
            ps.setLong(5, customer.getPhone_number());
            ps.setString(6, customer.getEmail());
            ps.setInt(7, customer.getCustomer_id());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomersUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}

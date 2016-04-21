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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customers;


/**
 *
 * @author KsS
 */
public class CustomersAdd {

    private Connection conn;
    private ResultSet results;

    public CustomersAdd() {

        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr = this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");

        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(CustomersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(CustomersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doAdd(Customers customer) {

        int counter = 0;
        counter = chooseID();
        customer.setCustomer_id(counter);

        try {
            String query = "Insert INTO Customers(customer_id, organization_name, person_in_charge, bank_account, adress, phone_number, email) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, customer.getCustomer_id());
            ps.setString(2, customer.getOrganization_name());
            ps.setString(3, customer.getPerson_in_charge());
            ps.setInt(4, customer.getBank_account());
            ps.setString(5, customer.getAdress());
            ps.setLong(6, customer.getPhone_number());
            ps.setString(7, customer.getEmail());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   

    public int chooseID() {
        int max=0;
        try {
            
            String query1 = "Select * from Customers";
            
            PreparedStatement ps = conn.prepareStatement(query1);
            this.results = ps.executeQuery();
            
            while (this.results.next()){
                Customers customer= new Customers();
                customer.setCustomer_id(this.results.getInt("Customer_id"));
                int temp=customer.getCustomer_id();
                if(temp>max) max=temp;
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (max+1);
    }
    
    public List findID(){
          
        List <Integer> list= new ArrayList<Integer>();
        try {
           
            String query2 = "Select * from Customers";
            PreparedStatement ps = conn.prepareStatement(query2);
            this.results = ps.executeQuery();
            while (this.results.next()) {
                Customers customer = new Customers();
                customer.setCustomer_id(this.results.getInt("Customer_id"));
                list.add(customer.getCustomer_id());
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
     }
    
    public String findOrganization_name(int i){
       String org_name="";
        try {
            String query="Select Organization_name from Customers where customer_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, i);
            this.results = ps.executeQuery();
              this.results.next();
            Customers customer = new Customers();
            customer.setOrganization_name(this.results.getString("Organization_name"));
            org_name=customer.getOrganization_name();
        } catch (SQLException ex) {
            Logger.getLogger(CustomersAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return org_name;
        
                                    
    }

}

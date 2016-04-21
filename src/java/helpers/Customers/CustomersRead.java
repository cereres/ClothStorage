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
public class CustomersRead {
    
    private Connection conn;
    private ResultSet results;
    
    public  CustomersRead(){
        
        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr= this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");
        
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(CustomersRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(CustomersRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver=props.getProperty("driver.name");
        String url=props.getProperty("server.name");
        String username=props.getProperty("user.name");
        String password=props.getProperty("user.password");
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomersRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn=DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead(){
            
        try {
            String query="Select * from Customers";
            
            PreparedStatement ps=conn.prepareStatement(query);
            this.results=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CustomersRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
     
     
     public String getHTMLTable(){
         String table="";
         table+="<table border=1>";
          table+="<tr>";
                table+="<td>";
                table+="Customer ID";
                table+="</td>";
                
                table+="<td>";
                table+="Organization name";
                table+="</td>";
                
                table+="<td>";
                table+="Person in Charge";
                table+="</td>";
                
                table+="<td>";
                table+="Bank Account";
                table+="</td>";
                
                table+="<td>";
                table+="Adress";
                table+="</td>";
                
                table+="<td>";
                table+="Phone Number";
                table+="</td>";
                
                table+="<td>";
                table+="Email";
                table+="</td>";
                
                table+="<td>";
                table+="Modification";
                table+="</td>";
                 table+="</tr>";
         
        try {
            while(this.results.next())
            {
                Customers customer= new Customers();
                customer.setCustomer_id(this.results.getInt("Customer_id"));
                customer.setOrganization_name(this.results.getString("Organization_name"));
                customer.setPerson_in_charge(this.results.getString("Person_in_charge"));
                customer.setBank_account(results.getInt("Bank_account"));
                customer.setAdress(this.results.getString("Adress"));
                customer.setPhone_number(this.results.getLong("Phone_number"));
                customer.setEmail(this.results.getString("Email"));
                
                table+="<tr>";
                table+="<td>";
                table+=customer.getCustomer_id();
                table+="</td>";
               
                
               
                table+="<td>";
                table+=customer.getOrganization_name();
                table+="</td>";
                
                
              
                table+="<td>";
                table+=customer.getPerson_in_charge();
                table+="</td>";
                
                
             
                table+="<td>";
                table+=customer.getBank_account();
                table+="</td>";
                
                
                
                table+="<td>";
                table+=customer.getAdress();
                table+="</td>";
             
                
               
                table+="<td>";
                table+=customer.getPhone_number();
                table+="</td>";
                
                
                
                table+="<td>";
                table+=customer.getEmail();
                table+="</td>";
                
                table+="<td>";
                table+="<a href=update?customer_id="+customer.getCustomer_id()+"> Update </a>"+"<a href=delete?customer_id="+customer.getCustomer_id()+"> Delete </a>";
                table+="</td>";
                
                
                table+="</tr>";
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomersRead.class.getName()).log(Level.SEVERE, null, ex);
        }
         table+="</table>";
         
         return table;
     }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.Order_Items;


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
import model.Order_Items;



/**
 *
 * @author KsS
 */
public class ItemsRead {

    private Connection conn;
    private ResultSet results;

    public ItemsRead() {
        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        InputStream instr = this.getClass().getClassLoader().getResourceAsStream("resources/dbConn.properties");

        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ItemsRead.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ItemsRead.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemsRead.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ItemsRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doRead() {

        try {
            String query = "Select * from Order_Items";

            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ItemsRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getHTMLTable(){
         String table="";
         table+="<table border=1>";
          table+="<tr>";
                table+="<td>";
                table+="Order Items ID";
                table+="</td>";
                
                table+="<td>";
                table+="Order ID";
                table+="</td>";
                
                table+="<td>";
                table+="Product ID";
                table+="</td>";
                
              
                
                table+="<td>";
                table+="Quantity";
                table+="</td>";
                
                                
                table+="<td>";
                table+="Modification";
                table+="</td>";
                 table+="</tr>";
         
        try {
            while(this.results.next())
            {
                Order_Items item= new Order_Items();
                item.setOrder_items_id(this.results.getInt("Order_Items_ID"));
                item.setOrder_id(this.results.getInt("Order_id"));
                item.setOrder_id(this.results.getInt("Order_id"));
                item.setProduct_id(this.results.getInt("Product_id"));
                item.setQuantity(this.results.getInt("Quantity"));
                
                
                
                table+="<tr>";
                table+="<td>";
                table+=item.getOrder_items_id();
                table+="</td>";
                
                
                table+="<td>";
                table+=item.getOrder_id();
                table+="</td>";
               
                
               
                table+="<td>";
                table+=item.getProduct_id();
                table+="</td>";
                
                   
             
                table+="<td>";
                table+=item.getQuantity();
                table+="</td>";
                
                
                
                table+="<td>";
                table+="<a href=update?item_id="+item.getOrder_items_id()+"> Update </a>"+"<a href=delete?item_id="+item.getOrder_items_id()+"> Delete </a>";
                table+="</td>";
                
                
                table+="</tr>";
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemsRead.class.getName()).log(Level.SEVERE, null, ex);
        }
         table+="</table>";
         
         return table;
     }
}

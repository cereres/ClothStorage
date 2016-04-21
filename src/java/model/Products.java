/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author KsS
 */
public class Products {
    
    private int product_id;
    private String product_name;
   
    private String category;
    private int list_price;
    private int product_amount;
    private int supplier_id;
    
    public Products() {
        this.product_id = 0;
        this.product_name = "";
     
        this.category = "";
        this.list_price = 0;
        this.product_amount = 0;
        this.supplier_id = 0;
    }

    public Products(int product_id, String product_name,  String category, int list_price, int product_amount, int supplier_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        
        this.category = category;
        this.list_price = list_price;
        this.product_amount = product_amount;
        this.supplier_id = supplier_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

  

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getList_price() {
        return list_price;
    }

    public void setList_price(int list_price) {
        this.list_price = list_price;
    }

    public int getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(int product_amount) {
        this.product_amount = product_amount;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }
    
    
    
    
}

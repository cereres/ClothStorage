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
public class Order_Items {
    
    private int order_items_id;
    private int order_id;
    private int product_id;
    private int quantity;
    
     public Order_Items() {
        this.order_items_id = 0;
        this.order_id = 0;
        this.product_id = 0;
        this.quantity = 0;
    }
     

    public Order_Items(int order_items_id, int order_id, int product_id, int quantity) {
        this.order_items_id = order_items_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public int getOrder_items_id() {
        return order_items_id;
    }

    public void setOrder_items_id(int order_items_id) {
        this.order_items_id = order_items_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
     
    
}

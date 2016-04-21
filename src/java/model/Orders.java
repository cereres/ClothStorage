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
public class Orders {
    
    private int order_id;
    private int customer_id;
    private int total_sum;
    
    public Orders() {
        this.order_id = 0;
        this.customer_id = 0;
        this.total_sum = 0;
    }

    public Orders(int order_id, int customer_id, int total_sum) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.total_sum = total_sum;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(int total_sum) {
        this.total_sum = total_sum;
    }
    
    
    
}

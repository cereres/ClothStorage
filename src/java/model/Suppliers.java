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
public class Suppliers {
    
    private int supplier_id;
    private String organization_name;
    private String person_in_charge;
    private String adress;
    private Long phone_number;
    private String email;
    
     public Suppliers() {
        this.supplier_id = 0;
        this.organization_name = "";
        this.person_in_charge = "";
        this.adress = "";
        this.phone_number = null;
        this.email = "";
    }

    public Suppliers(int supplier_id, String organization_name, String person_in_charge, String adress, Long phone_number, String email) {
        this.supplier_id = supplier_id;
        this.organization_name = organization_name;
        this.person_in_charge = person_in_charge;
        this.adress = adress;
        this.phone_number = phone_number;
        this.email = email;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public String getPerson_in_charge() {
        return person_in_charge;
    }

    public void setPerson_in_charge(String person_in_charge) {
        this.person_in_charge = person_in_charge;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}

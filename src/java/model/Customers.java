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
public class Customers {

    private int customer_id;
    private String organization_name;
    private String person_in_charge;
    private int bank_account;
    private String adress;
    private Long phone_number;
    private String email;

    public Customers() {
        this.customer_id = 0;
        this.organization_name = "";
        this.person_in_charge = "";
        this.bank_account = 0;
        this.adress = "";
        this.phone_number = null;
        this.email = "";
    }

    public Customers(int customer_id, String organization_name, String person_in_charge, int bank_account, String adress, Long phone_number, String email) {
        this.customer_id = customer_id;
        this.organization_name = organization_name;
        this.person_in_charge = person_in_charge;
        this.bank_account = bank_account;
        this.adress = adress;
        this.phone_number = phone_number;
        this.email = email;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
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

    public int getBank_account() {
        return bank_account;
    }

    public void setBank_account(int bank_account) {
        this.bank_account = bank_account;
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

    @Override
    public String toString() {
        return "Customers{" + "customer_id=" + customer_id + ", organization_name=" + organization_name + ", person_in_charge=" + person_in_charge + ", bank_account=" + bank_account + ", adress=" + adress + ", phone_number=" + phone_number + ", email=" + email + '}';
    }

}

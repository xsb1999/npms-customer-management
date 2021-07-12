package com.neu.customermanagement.management.dto.customer;

import com.neu.customermanagement.management.dto.common.Relation;
import com.neu.customermanagement.management.entity.Contact;
import com.neu.customermanagement.management.entity.Customer;

import java.io.Serializable;
import java.util.List;

public class AddCustomerInfo implements Serializable {

    private Customer customer;
    private List<Contact> contactList;
    private List<Relation> relationList;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Relation> getRelationList() {
        return relationList;
    }

    public void setRelationList(List<Relation> relationList) {
        this.relationList = relationList;
    }

    @Override
    public String toString() {
        return "AddCustomerInfo{" +
                "customer=" + customer +
                ", contactList=" + contactList +
                ", relationList=" + relationList +
                '}';
    }
}

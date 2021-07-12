package com.neu.customermanagement.management.dto.customer;

import com.neu.customermanagement.management.dto.common.Relation;
import com.neu.customermanagement.management.entity.Contact;
import com.neu.customermanagement.management.entity.Customer;

import java.io.Serializable;
import java.util.List;

public class UpdateCustomerInfo implements Serializable {

    private Customer customer;
    private List<Contact> addContactsList;
    private List<Contact> updateContactsList;
    private List<String> deleteContactsName;
    private List<Relation> addRelationList;
    private List<String> deleteRelationCusId;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Contact> getAddContactsList() {
        return addContactsList;
    }

    public void setAddContactsList(List<Contact> addContactsList) {
        this.addContactsList = addContactsList;
    }

    public List<Contact> getUpdateContactsList() {
        return updateContactsList;
    }

    public void setUpdateContactsList(List<Contact> updateContactsList) {
        this.updateContactsList = updateContactsList;
    }

    public List<String> getDeleteContactsName() {
        return deleteContactsName;
    }

    public void setDeleteContactsName(List<String> deleteContactsName) {
        this.deleteContactsName = deleteContactsName;
    }

    public List<Relation> getAddRelationList() {
        return addRelationList;
    }

    public void setAddRelationList(List<Relation> addRelationList) {
        this.addRelationList = addRelationList;
    }

    public List<String> getDeleteRelationCusId() {
        return deleteRelationCusId;
    }

    public void setDeleteRelationCusId(List<String> deleteRelationCusId) {
        this.deleteRelationCusId = deleteRelationCusId;
    }

    @Override
    public String toString() {
        return "UpdateCustomerInfo{" +
                "customer=" + customer +
                ", addContactsList=" + addContactsList +
                ", updateContactsList=" + updateContactsList +
                ", deleteContactsName=" + deleteContactsName +
                ", addRelationList=" + addRelationList +
                ", deleteRelationCusId=" + deleteRelationCusId +
                '}';
    }
}

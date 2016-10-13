package com.hibernate;

import com.sun.javafx.geom.transform.Identity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiranmai on 10/4/16.
 */
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "PersonId")
    @GeneratedValue
    private int pid;

    @Column(name = "first")
    private String first;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addressList = new ArrayList<Address>();

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public void addAddress(Address address){
        address.setPerson(this);
        addressList.add(address);
    }
}

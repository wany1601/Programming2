/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1review;

/**
 * Simple class of Address
 * @author Yi Wang
 */
public class Address {
    private int streetNum;
    private String street;
    private String city;

    public Address() {
        this.streetNum = 0;
        this.street = null;
        this.city = "";
    }
    
    public Address(int streetNum, String street, String city) {
        this.streetNum = streetNum;
        this.street = street;
        this.city = city;
    }
    
    public Address(Address address) {
        this.streetNum = address.streetNum;
        this.street = address.street;
        this.city = address.city;
    }
    
}

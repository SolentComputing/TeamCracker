/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ess.entity;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Dean
 */
public class Staff {
    
    private int id;
    private String firstName;
    private String lastName;
    private ObjectProperty<LocalDate> dob = new SimpleObjectProperty<>();
    private String email;
    private String addressOne;
    private String addressTwo;
    private String city;
    private String country;
    private String postcode;
    
    public Staff()
    {
        
    }
    
    public Staff setId(final int id)
    {
        this.id = id;
        return this;
    }
    
    public Staff setFirstName(final String firstName)
    {
        this.firstName = firstName;
        return this;
    }
    
    public Staff setLastName(final String lastName)
    {
        this.lastName = lastName;
        return this;
    }
    
    public Staff setDOB(final LocalDate dob)
    {
        this.dob.set(dob);
        return this;
    }
    
    public Staff setEmail(final String email)
    {
        this.email = email;
        return this;
    }
    
    public Staff setAddressOne(final String addressOne)
    {
        this.addressOne = addressOne;
        return this;
    }
    
    public Staff setAddressTwo(final String addressTwo)
    {
        this.addressTwo = addressTwo;
        return this;
    }
    
    public Staff setCity(final String city)
    {
        this.city = city;
        return this;
    }
    
    public Staff setCountry(final String country)
    {
        this.country = country;
        return this;
    }
    
    public Staff setPostcode(final String postcode)
    {
        this.postcode = postcode;
        return this;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public LocalDate getDOB()
    {
        return dob.get();
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getAddressOne()
    {
        return addressOne;
    }
    
    public String getAddressTwo()
    {
        return addressTwo;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public String getPostcode()
    {
        return postcode;
    }
    
    public final ObjectProperty<LocalDate> dobProperty()
    {
        return dob;
    }
    
}

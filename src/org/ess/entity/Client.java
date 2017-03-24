/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ess.entity;

/**
 *
 * @author Dean
 */
public class Client {
    
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String addressOne;
    private String addressTwo;
    private String city;
    private String country;
    private String postcode;
    
    public Client()
    {
        
    }
    
    public Client setId(final int id)
    {
        this.id = id;
        return this;
    }
    
    public Client setFirstName(final String firstName)
    {
        this.firstName = firstName;
        return this;
    }
    
    public Client setLastName(final String lastName)
    {
        this.lastName = lastName;
        return this;
    }
    
    public Client setEmail(final String email)
    {
        this.email = email;
        return this;
    }
    
    public Client setAddressOne(final String addressOne)
    {
        this.addressOne = addressOne;
        return this;
    }
    
    public Client setAddressTwo(final String addressTwo)
    {
        this.addressTwo = addressTwo;
        return this;
    }
    
    public Client setCity(final String city)
    {
        this.city = city;
        return this;
    }
    
    public Client setCountry(final String country)
    {
        this.country = country;
        return this;
    }
    
    public Client setPostcode(final String postcode)
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
    
    
    
}

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
public class User {
    
    private String username;
    private String password;
    private boolean admin;
    
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private int gender;
    private ObjectProperty<LocalDate> dob = new SimpleObjectProperty<>();
    private String country;
    private String state;
    private String postcode;
    
    private String telephoneNumber;
    private String email;
    
    public User()
    {
        this.username = "";
        this.password = "";
        this.admin = false;
        
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.gender = 0;
        this.dob.set(LocalDate.now());
        this.country = "";
        this.state = "";
        this.postcode = "";
        this.telephoneNumber = "";
        this.email = "";
    }
    
    public User setUsername(final String username)
    {
        this.username = username;
        return this;
    }
    
    public User setPassword(final String password)
    {
        this.password = password;
        return this;
    }
    
    public User setAdministrator(final boolean admin)
    {
        this.admin = admin;
        return this;
    }
    
    public User setId(final int id)
    {
        this.id = id;
        return this;
    }
    
    public User setFirstName(final String firstName)
    {
        this.firstName = firstName;
        return this;
    }
    
    public User setMiddleName(final String middleName)
    {
        this.middleName = middleName;
        return this;
    }
    
    public User setLastName(final String lastName)
    {
        this.lastName = lastName;
        return this;
    }
    
    public User setGender(final int gender)
    {
        this.gender = gender;
        return this;
    }
    
    public User setDob(final LocalDate dob)
    {
        this.dob.set(dob);
        return this;
    }
    
    public User setCountry(final String country)
    {
        this.country = country;
        return this;
    }
    
    public User setState(final String state)
    {
        this.state = state;
        return this;
    }
    
    public User setPostcode(final String postcode)
    {
        this.postcode = postcode;
        return this;
    }
    
    public User setTelephoneNumber(final String telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
        return this;
    }
    
    public User setEmail(final String email)
    {
        this.email = email;
        return this;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public int getId()
    {
        return id;
    }
    
    public boolean getAdmin()
    {
        return admin;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getMiddleName()
    {
        return middleName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public int getGender()
    {
        return gender;
    }
    
    public LocalDate getDob()
    {
        return dob.get();
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public String getState()
    {
        return state;
    }
    
    public String getPostcode()
    {
        return postcode;
    }
    
    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }
    
    public String getEmail()
    {
        return email;
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ess.entity;

import org.ess.Database;

/**
 *
 * @author Dean
 */
public class Service {
    
    private int id;
    private String name;
    private String description;
    private int staffId;
    
    public Service()
    {

    }
    
    public Service setId(final int id)
    {
        this.id = id;
        return this;
    }
    
    public Service setName(final String name)
    {
        this.name = name;
        return this;
    }
    
    public Service setDescription(final String description)
    {
        this.description = description;
        return this;
    }
    
    public Service setStaffId(final int staffId)
    {
        this.staffId = staffId;
        return this;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public int getStaffId()
    {
        return staffId;
    }
    
    public String getStaffName()
    {
        final Staff staff = Database.getStaff(staffId);
        return staff == null ? "N/a" : staff.getFirstName() + " " + staff.getLastName();
    }
    
}

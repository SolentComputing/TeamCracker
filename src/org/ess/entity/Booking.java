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
public class Booking {
    
    private int id;
    private int serviceId;
    private int clientId;
    
    public Booking() { }
    
    public Booking setId(final int id)
    {
        this.id = id;
        return this;
    }
    
    public Booking setServiceId(final int serviceId)
    {
        this.serviceId = serviceId;
        return this;
    }
    
    public Booking setClientId(final int clientId)
    {
        this.clientId = clientId;
        return this;
    }
    
    public int getId()
    {
        return id;
    }
    
    public int getServiceId()
    {
        return serviceId;
    }
    
    public int getClientId()
    {
        return clientId;
    }
    
    public String getServiceName()
    {
        final Service service = Database.getService(serviceId);
        return service == null ? "Invalid" : service.getName();
    }
    
    public String getClientName()
    {
        final Client client = Database.getClient(clientId);
        return client == null ? "N/a" : client.getFirstName() + " " + client.getLastName();
    }
    
}

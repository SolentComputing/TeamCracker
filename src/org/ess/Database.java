/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ess;

import java.util.ArrayList;
import org.ess.entity.Client;

/**
 *
 * @author Dean
 */
public class Database {
    
    public static ArrayList<Client> CLIENT_MAP = new ArrayList<>();
    
    public static void addClient(final Client client)
    {
        int highest = 0;
        for (final Client c : CLIENT_MAP)
        {
            if(c.getId() >= highest)
            {
                highest = c.getId() + 1;
                continue;
            }
        }
        CLIENT_MAP.add(client.setId(highest));
    }
    
    public static void deleteClient(final Client client)
    {
        CLIENT_MAP.remove(client);
    }
        
    
}

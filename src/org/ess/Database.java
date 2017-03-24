/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ess;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import org.ess.entity.Client;
import org.ess.entity.Staff;

/**
 *
 * @author Dean
 */
public class Database {
    
    public static ArrayList<Client> CLIENT_MAP = new ArrayList<>();
    public static ArrayList<Staff> STAFF_MAP = new ArrayList<>();
    
    public static void loadDatabase() throws IOException
    {
        final File databaseFile = new File("./database.dat");
        if(!databaseFile.exists())
        {
            System.out.println("No database file available.");
            return;
        }
        final DataInputStream input = new DataInputStream(new FileInputStream("./database.dat"));
        final int clientSize = input.readShort();
        final int staffSize = input.readShort();
        for (int index = 0; index < clientSize; index++)
        {
            final Client client = new Client().setId(input.readShort())
                                              .setFirstName(input.readUTF())
                                              .setLastName(input.readUTF())
                                              .setEmail(input.readUTF())
                                              .setAddressOne(input.readUTF())
                                              .setAddressTwo(input.readUTF())
                                              .setCity(input.readUTF())
                                              .setCountry(input.readUTF())
                                              .setPostcode(input.readUTF());
            CLIENT_MAP.add(client);
        }
        for (int index = 0; index < staffSize; index++)
        {
            final Staff staff = new Staff().setId(input.readShort())
                                           .setFirstName(input.readUTF())
                                           .setLastName(input.readUTF())
                                           .setDOB(LocalDate.ofEpochDay(input.readLong()))
                                           .setEmail(input.readUTF())
                                           .setAddressOne(input.readUTF())
                                           .setAddressTwo(input.readUTF())
                                           .setCity(input.readUTF())
                                           .setCountry(input.readUTF())
                                           .setPostcode(input.readUTF());
            STAFF_MAP.add(staff);
        }
    }
        
    
    public static void saveDatabase() throws IOException
    {
        final DataOutputStream output = new DataOutputStream(new FileOutputStream("./database.dat"));
        output.writeShort(CLIENT_MAP.size());
        output.writeShort(STAFF_MAP.size());
        for (final Client client : CLIENT_MAP)
        {
            output.writeShort(client.getId());
            output.writeUTF(client.getFirstName());
            output.writeUTF(client.getLastName());
            output.writeUTF(client.getEmail());
            output.writeUTF(client.getAddressOne());
            output.writeUTF(client.getAddressTwo());
            output.writeUTF(client.getCity());
            output.writeUTF(client.getCountry());
            output.writeUTF(client.getPostcode());
        }
        for (final Staff staff : STAFF_MAP)
        {
            output.writeShort(staff.getId());
            output.writeUTF(staff.getFirstName());
            output.writeUTF(staff.getLastName());
            output.writeLong(staff.getDOB().toEpochDay());
            output.writeUTF(staff.getEmail());
            output.writeUTF(staff.getAddressOne());
            output.writeUTF(staff.getAddressTwo());
            output.writeUTF(staff.getCity());
            output.writeUTF(staff.getCountry());
            output.writeUTF(staff.getPostcode());
        }
        output.flush();
        output.close();
    }
    
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
        
    public static void addStaff(final Staff staff)
    {
        int highest = 0; 
        for (final Staff s : STAFF_MAP)
        {
            if(s.getId() >= highest)
            {
                highest = s.getId() + 1;
                continue;
            }
        }
        STAFF_MAP.add(staff.setId(highest));
    }
    
    public static void deleteStaff(final Staff staff)
    {
        STAFF_MAP.remove(staff);
    }
    
}

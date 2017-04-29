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
import org.ess.entity.Booking;
import org.ess.entity.Client;
import org.ess.entity.Service;
import org.ess.entity.Staff;
import org.ess.entity.User;

/**
 *
 * @author Dean
 */
public class Database {
    
    public static ArrayList<Client> CLIENT_MAP = new ArrayList<>();
    public static ArrayList<Staff> STAFF_MAP = new ArrayList<>();
    public static ArrayList<Service> SERVICE_MAP = new ArrayList<>();
    public static ArrayList<Booking> BOOKING_MAP = new ArrayList<>();
    public static ArrayList<User> USER_MAP = new ArrayList<>();
    
    public static void loadDatabase() throws IOException
    {
        final File databaseFile = new File("./database.dat");
        if(!databaseFile.exists())
        {
            System.out.println("No database file available.");
            System.out.println("Generating users.");
            final User admin = new User().setId(0)
                                         .setUsername("admin")
                                         .setPassword("admin")
                                         .setAdministrator(true);
            final User user = new User().setId(1)
                                        .setUsername("user")
                                        .setPassword("user")
                                        .setAdministrator(false);
            USER_MAP.add(admin);
            USER_MAP.add(user);       
            return;
        }
        final DataInputStream input = new DataInputStream(new FileInputStream("./database.dat"));
        final int clientSize = input.readShort();
        final int staffSize = input.readShort();
        final int serviceSize = input.readShort();
        final int bookingSize = input.readShort();
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
        for (int index = 0; index < serviceSize; index++)
        {
            final Service service = new Service().setId(input.readShort())
                                                 .setName(input.readUTF())
                                                 .setDescription(input.readUTF())
                                                 .setStaffId(input.readShort());
            SERVICE_MAP.add(service);
        }
        for (int index = 0; index < bookingSize; index++)
        {
            final Booking booking = new Booking().setId(input.readShort())
                                                 .setServiceId(input.readShort())
                                                 .setClientId(input.readShort());
            BOOKING_MAP.add(booking);
        }
        if(input.available() > 0)
        {
            System.out.println("Reading users.");
            final int userSize = input.readShort();
            for (int index = 0; index < userSize; index++)
            {
                final User user = new User().setId(input.readShort())
                                            .setUsername(input.readUTF())
                                            .setPassword(input.readUTF())
                                            .setAdministrator(input.readBoolean())
                                            .setFirstName(input.readUTF())
                                            .setMiddleName(input.readUTF())
                                            .setLastName(input.readUTF())
                                            .setGender((int) input.readByte())
                                            .setDob(LocalDate.ofEpochDay(input.readLong()))
                                            .setCountry(input.readUTF())
                                            .setState(input.readUTF())
                                            .setPostcode(input.readUTF())
                                            .setTelephoneNumber(input.readUTF())
                                            .setEmail(input.readUTF());
                USER_MAP.add(user);
            }                                
        } else
        {
            System.out.println("Generating users.");
            final User admin = new User().setId(0)
                                         .setUsername("admin")
                                         .setPassword("admin")
                                         .setAdministrator(true);
            final User user = new User().setId(1)
                                        .setUsername("user")
                                        .setPassword("user")
                                        .setAdministrator(false);
            USER_MAP.add(admin);
            USER_MAP.add(user);                           
        }
    }
        
    
    public static void saveDatabase() throws IOException
    {
        final DataOutputStream output = new DataOutputStream(new FileOutputStream("./database.dat"));
        output.writeShort(CLIENT_MAP.size());
        output.writeShort(STAFF_MAP.size());
        output.writeShort(SERVICE_MAP.size());
        output.writeShort(BOOKING_MAP.size());
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
        for (final Service service : SERVICE_MAP)
        {
            output.writeShort(service.getId());
            output.writeUTF(service.getName());
            output.writeUTF(service.getDescription());
            output.writeShort(service.getStaffId());
        }
        for (final Booking booking : BOOKING_MAP)
        {
            output.writeShort(booking.getId());
            output.writeShort(booking.getServiceId());
            output.writeShort(booking.getClientId());
        }
        output.writeShort(USER_MAP.size());
        for (final User user : USER_MAP)
        {
            output.writeShort(user.getId());
            output.writeUTF(user.getUsername());
            output.writeUTF(user.getPassword());
            output.writeBoolean(user.getAdmin());
            output.writeUTF(user.getFirstName());
            output.writeUTF(user.getMiddleName());
            output.writeUTF(user.getLastName());
            output.writeByte(user.getGender());
            output.writeLong(user.getDob().toEpochDay());
            output.writeUTF(user.getCountry());
            output.writeUTF(user.getState());
            output.writeUTF(user.getPostcode());
            output.writeUTF(user.getTelephoneNumber());
            output.writeUTF(user.getEmail());
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
        
    public static Client getClient(final int id)
    {
        for (final Client client : CLIENT_MAP)
        {
            if(client.getId() == id)
                return client;
        }
        return null;
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
    
    public static Staff getStaff(final int staffId)
    {
        for (final Staff s : STAFF_MAP)
        {
            if(s.getId() == staffId)
                return s;
        }
        return null;
    }
    
    public static void addService(final Service service)
    {
        int highest = 0;
        for (final Service s : SERVICE_MAP)
        {
            if(s.getId() >= highest)
            {
                highest = s.getId() + 1;
                continue;
            }
        }
        SERVICE_MAP.add(service.setId(highest));
    }
    
    public static void deleteService(final Service service)
    {
        SERVICE_MAP.remove(service);
    }
    
    public static ArrayList<Service> getServices()
    {
        return SERVICE_MAP;
    }
    
    public static Service getService(final int id)
    {
        for (final Service service : SERVICE_MAP)
        {
            if(service.getId() == id)
                return service;
        }
        return null;
    }
    
    public static void addBooking(final Booking booking)
    {
        int highest = 0; 
        for (final Booking b : BOOKING_MAP)
        {
            if(b.getId() >= highest)
            {
                highest = b.getId() + 1;
                break;
            }
        }
        BOOKING_MAP.add(booking.setId(highest));
    }
    
    public static void deleteBooking(final Booking booking)
    {
        BOOKING_MAP.remove(booking);
    }
    
    public static ArrayList<Booking> getBookings()
    {
        return BOOKING_MAP;
    }
    
    public static ArrayList<User> getUsers()
    {
        return USER_MAP;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ess.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.ess.Database;
import org.ess.entity.Booking;
import org.ess.entity.Client;
import org.ess.entity.Service;
import org.ess.entity.Staff;

/**
 *
 * @author Dean
 */
public class MainController implements Initializable {
    
    private static MainController instance;
    
    private Stage addClientStage;
    private Stage addStaffStage;
    private Stage addServiceStage;
    private Stage addBookingStage;
    
    private Stage viewClientStage;
    private Stage viewStaffStage;
    private Stage viewServiceStage;
    private Stage viewBookingStage;
    
    /*
     * Client Table
    */
    @FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn<Client, Integer> clientId;
    @FXML
    private TableColumn<Client, String> clientFName;
    @FXML
    private TableColumn<Client, String> clientLName;
    @FXML
    private TableColumn<Client, String> clientEmail;
    @FXML
    private TableColumn<Client, String> clientAddress;
    @FXML
    private TableColumn<Client, String> clientService;
    
    /*
     * Staff Table
    */
    @FXML
    private TableView<Staff> staffTable;
    @FXML
    private TableColumn<Staff, Integer> staffId;
    @FXML
    private TableColumn<Staff, String> staffFName;
    @FXML
    private TableColumn<Staff, String> staffLName;
    @FXML
    private TableColumn<Staff, LocalDate> staffDOB;
    @FXML
    private TableColumn<Staff, String> staffEmail;
    @FXML
    private TableColumn<Staff, String> staffAddress;
    @FXML
    private TableColumn<Staff, String> staffRole;
    @FXML
    private TableColumn<Staff, Boolean> staffAvailable;
    
    /*
     * Service Table
    */
    @FXML
    private TableView<Service> serviceTable;
    @FXML
    private TableColumn<Service, Integer> serviceId;
    @FXML
    private TableColumn<Service, String> serviceName;
    @FXML
    private TableColumn<Service, String> serviceDesc;
    @FXML
    private TableColumn<Service, String> serviceStaff;
    
    /*
     * Booking Table
    */
    @FXML
    private TableView<Booking> bookingTable;
    @FXML
    private TableColumn<Booking, Integer> bookingId;
    @FXML
    private TableColumn<Booking, String> bookingSName;
    @FXML
    private TableColumn<Booking, Integer> bookingCID;
    @FXML
    private TableColumn<Booking, String> bookingCName;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        instance = this;
        clientId.setCellValueFactory(new PropertyValueFactory<>("id"));
        clientFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        clientLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        clientEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        clientAddress.setCellValueFactory(new PropertyValueFactory<>("addressOne"));
        clientService.setCellValueFactory(new PropertyValueFactory<>("postcode"));
        
        staffId.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        staffLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        staffDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        staffEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        staffAddress.setCellValueFactory(new PropertyValueFactory<>("addressOne"));
        
        serviceId.setCellValueFactory(new PropertyValueFactory<>("id"));
        serviceName.setCellValueFactory(new PropertyValueFactory<>("name"));
        serviceDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        serviceStaff.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        
        bookingId.setCellValueFactory(new PropertyValueFactory<>("id"));
        bookingSName.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        bookingCID.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        bookingCName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        
        clientTable.getItems().clear();
        clientTable.getItems().addAll(Database.CLIENT_MAP);
        
        staffTable.getItems().clear();
        staffTable.getItems().addAll(Database.STAFF_MAP);
        
        serviceTable.getItems().clear();
        serviceTable.getItems().addAll(Database.SERVICE_MAP);
        
        bookingTable.getItems().clear();
        bookingTable.getItems().addAll(Database.BOOKING_MAP);
    }
    
    @FXML
    private void logout() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/layout/Login.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) staffTable.getScene().getWindow();
        stage.setScene(scene);
    }
    
    @FXML
    private void addNewClient() throws IOException
    {
        System.out.println("Add new client");
        if(addClientStage != null)
        {
            addClientStage.show();
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("/layout/add-new-client.fxml"));
        Scene scene = new Scene(root);
        addClientStage = new Stage();
        addClientStage.setScene(scene);
        addClientStage.show();
    }
    
    @FXML
    private void addNewStaff() throws IOException
    {
        System.out.println("Add new staff");
        if(addStaffStage != null)
        {
            addStaffStage.show();
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("/layout/add-new-staff.fxml"));
        Scene scene = new Scene(root);
        addStaffStage = new Stage();
        addStaffStage.setScene(scene);
        addStaffStage.show();
    }
    
    @FXML
    private void addNewService() throws IOException
    {
        System.out.println("Add new service");
        if(addServiceStage != null)
        {
            addServiceStage.show();
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("/layout/add-new-service.fxml"));
        Scene scene = new Scene(root);
        addServiceStage = new Stage();
        addServiceStage.setScene(scene);
        addServiceStage.show();
    }
    
    @FXML
    private void addNewBooking() throws IOException
    {
        System.out.println("Add new booking");
        if(addBookingStage != null)
        {
            addBookingStage.show();
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("/layout/add-new-booking.fxml"));
        Scene scene = new Scene(root);
        addBookingStage = new Stage();
        addBookingStage.setScene(scene);
        addBookingStage.show();
    }
    
    @FXML
    private void viewClient() throws IOException
    {
        if(clientTable.getSelectionModel().getSelectedItem() == null)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a Client to view.");
            alert.showAndWait();
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("/layout/modify-client.fxml"));
        Scene scene = new Scene(root);
        viewClientStage = new Stage();
        viewClientStage.setScene(scene);
        viewClientStage.show();
    }
    
    @FXML
    private void viewStaff() throws IOException
    {
        if(staffTable.getSelectionModel().getSelectedItem() == null)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a staff member to view.");
            alert.showAndWait();
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("/layout/modify-staff.fxml"));
        Scene scene = new Scene(root);
        viewStaffStage = new Stage();
        viewStaffStage.setScene(scene);
        viewStaffStage.show();
    }
    
    @FXML
    private void viewService() throws IOException
    {
        if(serviceTable.getSelectionModel().getSelectedItem() == null)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a service to view.");
            alert.showAndWait();
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("/layout/modify-service.fxml"));
        Scene scene = new Scene(root);
        viewServiceStage = new Stage();
        viewServiceStage.setScene(scene);
        viewServiceStage.show();
    }
    
    @FXML
    private void viewBooking() throws IOException
    {
        if(bookingTable.getSelectionModel().getSelectedItem() == null)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a booking to view.");
            alert.showAndWait();
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("/layout/modify-booking.fxml"));
        Scene scene = new Scene(root);
        viewBookingStage = new Stage();
        viewBookingStage.setScene(scene);
        viewBookingStage.show();
    }
    
    @FXML
    private void deleteClient()
    {
        if(clientTable.getSelectionModel().getSelectedItem() == null)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a Client to delete.");
            alert.showAndWait();
            return;
        }
        if(clientTable.getSelectionModel().getSelectedItem() != null)
        {
            Database.deleteClient(clientTable.getSelectionModel().getSelectedItem());
            updateTables();
            return;
        }
    }
    
    @FXML
    private void deleteStaff()
    {
        if(staffTable.getSelectionModel().getSelectedItem() == null)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a Staff to delete.");
            alert.showAndWait();
            return;
        }
        if(staffTable.getSelectionModel().getSelectedItem() != null)
        {
            Database.deleteStaff(staffTable.getSelectionModel().getSelectedItem());
            updateTables();
            return;
        }
    }
    
    @FXML
    private void deleteService()
    {
        if(serviceTable.getSelectionModel().getSelectedItem() == null)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a service to delete.");
            alert.showAndWait();
            return;
        }
        if(serviceTable.getSelectionModel().getSelectedItem() != null)
        {
            Database.deleteService(serviceTable.getSelectionModel().getSelectedItem());
            updateTables();
            return;
        }
    }
    
    @FXML
    private void deleteBooking()
    {
        if(bookingTable.getSelectionModel().getSelectedItem() == null)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a booking to delete.");
            alert.showAndWait();
            return;
        }
        if(bookingTable.getSelectionModel().getSelectedItem() != null)
        {
            Database.deleteBooking(bookingTable.getSelectionModel().getSelectedItem());
            updateTables();
            return;
        }
    }
    
    public void updateTables()
    {
        clientTable.getItems().clear();
        clientTable.getItems().addAll(Database.CLIENT_MAP);
        
        staffTable.getItems().clear();
        staffTable.getItems().addAll(Database.STAFF_MAP);
        
        serviceTable.getItems().clear();
        serviceTable.getItems().addAll(Database.SERVICE_MAP);
        
        bookingTable.getItems().clear();
        bookingTable.getItems().addAll(Database.BOOKING_MAP);
    }
    
    public static Client getSelectedClient()
    {
        return instance.clientTable.getSelectionModel().getSelectedItem();
    }
    
    public static Staff getSelectedStaff()
    {
        return instance.staffTable.getSelectionModel().getSelectedItem();
    }
    
    public static Service getSelectedService()
    {
        return instance.serviceTable.getSelectionModel().getSelectedItem();
    }
    
    public static Booking getSelectedBooking()
    {
        return instance.bookingTable.getSelectionModel().getSelectedItem();
    }
    
    public static MainController getController()
    {
        return instance;
    }
    
    
}

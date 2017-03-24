/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ess.controller;

import java.io.IOException;
import java.net.URL;
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
import org.ess.entity.Client;

/**
 *
 * @author Dean
 */
public class MainController implements Initializable {
    
    private static MainController instance;
    
    private Stage addClientStage;
    private Stage addStaffStage;
    private Stage viewClientStage;
    private Stage viewStaffStage;
    
    
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
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        instance = this;
        clientId.setCellValueFactory(new PropertyValueFactory<>("id"));
        clientFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        clientLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        clientEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        clientAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        clientService.setCellValueFactory(new PropertyValueFactory<>("postcode"));
        
        Client client = new Client().setFirstName("Dave")
                                    .setLastName("Davidson")
                                    .setEmail("dave@davemail.org")
                                    .setAddressOne("1 Coventry Road")
                                    .setAddressTwo("Address two")
                                    .setCity("Southampton")
                                    .setPostcode("SO15 XXX")
                                    .setCountry("England");
        
        Database.addClient(client);
        
        Client ben = new Client().setFirstName("Ben")
                                 .setLastName("Benson")
                                    .setEmail("ben@benmail.org")
                                    .setAddressOne("5 Coventry Road")
                                    .setAddressTwo("Address two")
                                    .setCity("Southampton")
                                    .setPostcode("SO15 XXX")
                                    .setCountry("England");
        Database.addClient(ben);
        
        clientTable.getItems().clear();
        clientTable.getItems().addAll(Database.CLIENT_MAP);
        
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
    private void addNewStaff()
    {
        System.out.println("add new staff");
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
    private void viewStaff()
    {
        
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
        System.out.println("Delete staff");
    }
    
    public void updateTables()
    {
        clientTable.getItems().clear();
        clientTable.getItems().addAll(Database.CLIENT_MAP);
    }
    
    public static Client getSelectedClient()
    {
        return instance.clientTable.getSelectionModel().getSelectedItem();
    }
    
    public static MainController getController()
    {
        return instance;
    }
    
    
}

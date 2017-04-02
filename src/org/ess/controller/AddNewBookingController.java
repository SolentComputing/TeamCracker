/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ess.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import org.ess.Database;
import org.ess.entity.Booking;
import org.ess.entity.Client;
import org.ess.entity.Service;

/**
 *
 * @author Dean
 */
public class AddNewBookingController implements Initializable {
    
    @FXML
    private TextField serviceIDInput;
    @FXML
    private TextField serviceIDName;
    @FXML
    private TextField clientIDInput;
    @FXML
    private TextField clientIDName;
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        serviceIDInput.textProperty().addListener((observable, oldValue, newValue) -> {
            
            onUpdateService();
            
        });
        clientIDInput.textProperty().addListener((observable, oldValue, newValue) -> {
            
            onUpdateClient();
            
        });
       
    }
    
    @FXML
    private void onAdd(final ActionEvent event)
    {
        if(onUpdateService() && onUpdateClient())
        {
            final Booking booking = new Booking().setServiceId(Integer.parseInt(serviceIDInput.getText()))
                                                 .setClientId(Integer.parseInt(clientIDInput.getText()));
            Database.addBooking(booking);
            MainController.getController().updateTables();
        
            serviceIDInput.setText("");
            serviceIDName.setText("");
            clientIDInput.setText("");
            clientIDName.setText("");
        
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    }
    
    @FXML
    private void onCancel(final ActionEvent event)
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    private boolean onUpdateService()
    {
        serviceIDInput.setStyle("");
        try {
            final int serviceId = Integer.parseInt(serviceIDInput.getText());
            final Service service = Database.getService(serviceId);
            if(service == null)
            {
                serviceIDInput.setStyle("-fx-border-color: red;");
                serviceIDName.setText("Invalid service ID");
                return false;
            } else
            {
                serviceIDName.setText(service.getName());
                return true;
            }
        } catch(final NumberFormatException nfe) {
            serviceIDInput.setStyle("-fx-border-color: red;");
            serviceIDName.setText("Invalid Staff ID");
            return false;
        }
    }
    
    private boolean onUpdateClient()
    {
        clientIDInput.setStyle("");
        try {
            final int clientId = Integer.parseInt(clientIDInput.getText());
            final Client client = Database.getClient(clientId);
            if(client == null)
            {
                clientIDInput.setStyle("-fx-border-color: red;");
                clientIDName.setText("Invalid client ID");
                return false;
            } else
            {
                clientIDName.setText(client.getFirstName() + " " + client.getLastName());
                return true;
            }
        } catch(final NumberFormatException nfe) {
            clientIDInput.setStyle("-fx-border-color: red;");
            clientIDName.setText("Invalid client ID");
            return false;
        }
    }
    
}

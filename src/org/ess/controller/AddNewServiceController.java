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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.ess.Database;
import org.ess.entity.Service;
import org.ess.entity.Staff;

/**
 *
 * @author Dean
 */
public class AddNewServiceController implements Initializable {
    
    @FXML
    private TextField serviceNameInput;
    @FXML
    private TextArea serviceDescInput;
    @FXML
    private TextField staffIDInput;
    @FXML
    private TextField staffIDName;
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        staffIDInput.textProperty().addListener((observable, oldValue, newValue) -> {
            
            onUpdate();
            
        });
       
    }
    
    @FXML
    private void onAdd(final ActionEvent event)
    {
        final TextField[] validations = {
            serviceNameInput,
            staffIDInput
        };
        boolean isValid = true;
        serviceDescInput.setStyle("");
        for (final TextField valid : validations)
        {
            valid.setStyle("");
            if(valid.getText() == null || valid.getText().isEmpty())
            {
                valid.setStyle("-fx-border-color: red;");
                isValid = false;
                break;
            }
        }
        if(isValid)
        {
            if(serviceDescInput.getText() == null || serviceDescInput.getText().isEmpty())
            {
                serviceDescInput.setStyle("-fx-border-color: red;");
                isValid = false;
            }
        }
        if(!isValid)
        {
            System.out.println("Not all fields valid.");
            return;
        }
        if(onUpdate())
        {
            final Service service = new Service().setName(serviceNameInput.getText())
                                                 .setDescription(serviceDescInput.getText())
                                                 .setStaffId(Integer.parseInt(staffIDInput.getText()));
            Database.addService(service);
            MainController.getController().updateTables();
        
            for (final TextField inputField : validations)
            {
                inputField.setText("");
            }
        
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    }
    
    @FXML
    private void onCancel(final ActionEvent event)
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    private boolean onUpdate()
    {
        staffIDInput.setStyle("");
        try {
            final int staffId = Integer.parseInt(staffIDInput.getText());
            final Staff staff = Database.getStaff(staffId);
            if(staff == null)
            {
                staffIDInput.setStyle("-fx-border-color: red;");
                staffIDName.setText("Invalid Staff ID");
                return false;
            } else
            {
                staffIDName.setText(staff.getFirstName() + " " + staff.getLastName());
                return true;
            }
        } catch(final NumberFormatException nfe) {
            staffIDInput.setStyle("-fx-border-color: red;");
            staffIDName.setText("Invalid Staff ID");
            return false;
        }
    }
    
}

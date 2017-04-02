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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.ess.Database;
import org.ess.entity.Staff;

/**
 *
 * @author Dean
 */
public class AddNewStaffController implements Initializable {

    @FXML
    private TextField firstNameInput;
    @FXML
    private TextField lastNameInput;
    @FXML
    private DatePicker dateInput;
    @FXML
    private TextField emailInput;
    @FXML
    private TextField addressOneInput;
    @FXML
    private TextField addressTwoInput;
    @FXML
    private TextField cityInput;
    @FXML
    private TextField countryInput;
    @FXML
    private TextField postcodeInput;
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        
    }
    
    @FXML
    private void onAdd(final ActionEvent event)
    {
        final TextField[] validations = {
            firstNameInput,
            lastNameInput,
            emailInput,
            addressOneInput,
            cityInput,
            countryInput,
            postcodeInput
        };
        boolean isValid = true;
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
        if(!isValid)
        {
            System.out.println("Not all fields valid.");
            return;
        }
        Staff staff = new Staff().setFirstName(firstNameInput.getText())
                                    .setLastName(lastNameInput.getText())
                                    .setDOB(dateInput.getValue())
                                    .setEmail(emailInput.getText())
                                    .setAddressOne(addressOneInput.getText())
                                    .setAddressTwo(addressTwoInput.getText())
                                    .setCity(cityInput.getText())
                                    .setCountry(countryInput.getText())
                                    .setPostcode(postcodeInput.getText());
        
        Database.addStaff(staff);
        MainController.getController().updateTables();
        
        for (final TextField inputField : validations)
        {
            inputField.setText("");
        }
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void onCancel(final ActionEvent event)
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
}

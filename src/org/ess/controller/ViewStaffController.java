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
import org.ess.entity.Staff;

/**
 *
 * @author Dean
 */
public class ViewStaffController implements Initializable {
    
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
        final Staff staff = MainController.getSelectedStaff();
        if(staff == null)
            return;
        firstNameInput.setText(staff.getFirstName());
        lastNameInput.setText(staff.getLastName());
        dateInput.setValue(staff.getDOB());
        emailInput.setText(staff.getEmail());
        addressOneInput.setText(staff.getAddressOne());
        addressTwoInput.setText(staff.getAddressTwo());
        cityInput.setText(staff.getCity());
        countryInput.setText(staff.getCountry());
        postcodeInput.setText(staff.getPostcode());
    }

    @FXML
    private void onSave(final ActionEvent event)
    {
        final Staff staff = MainController.getSelectedStaff();
        if(staff == null)
            return;
        staff.setFirstName(firstNameInput.getText())
              .setLastName(lastNameInput.getText())
              .setDOB(dateInput.getValue())
              .setEmail(emailInput.getText())
              .setAddressOne(addressOneInput.getText())
              .setAddressTwo(addressTwoInput.getText())
              .setCity(cityInput.getText())
              .setCountry(countryInput.getText())
              .setPostcode(postcodeInput.getText());
        MainController.getController().updateTables();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void onCancel(final ActionEvent event)
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
}

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
import org.ess.entity.Client;

/**
 *
 * @author Dean
 */
public class ViewClientController implements Initializable {
    
    @FXML
    private TextField firstNameInput;
    @FXML
    private TextField lastNameInput;
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
        final Client client = MainController.getSelectedClient();
        if(client == null)
            return;
        firstNameInput.setText(client.getFirstName());
        lastNameInput.setText(client.getLastName());
        emailInput.setText(client.getEmail());
        addressOneInput.setText(client.getAddressOne());
        addressTwoInput.setText(client.getAddressTwo());
        cityInput.setText(client.getCity());
        countryInput.setText(client.getCountry());
        postcodeInput.setText(client.getPostcode());
    }

    @FXML
    private void onSave(final ActionEvent event)
    {
        final Client client = MainController.getSelectedClient();
        if(client == null)
            return;
        client.setFirstName(firstNameInput.getText())
              .setLastName(lastNameInput.getText())
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

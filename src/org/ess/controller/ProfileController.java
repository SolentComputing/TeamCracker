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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.ess.entity.User;

/**
 *
 * @author Dean
 */
public class ProfileController implements Initializable {
    
    @FXML
    private TextField firstNameInput;
    @FXML
    private TextField middleNameInput;
    @FXML
    private TextField lastNameInput;
    @FXML
    private RadioButton maleGenderInput;
    @FXML
    private RadioButton femaleGenderInput;
    @FXML
    private DatePicker dobInput;
    @FXML
    private TextField countryInput;
    @FXML
    private TextField stateInput;
    @FXML
    private TextField postcodeInput;
    @FXML
    private TextField telephoneInput;
    @FXML
    private TextField emailInput;
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
       final User user = LoginController.getInstance().loggedUser;
       if(user == null)
           return;
       firstNameInput.setText(user.getFirstName());
       middleNameInput.setText(user.getMiddleName());
       lastNameInput.setText(user.getLastName());
       if(user.getGender() == 0)
       {
           maleGenderInput.setSelected(true);
           femaleGenderInput.setSelected(false);
       } else
       {
           maleGenderInput.setSelected(false);
           femaleGenderInput.setSelected(true);
       }
       dobInput.setValue(user.getDob());
       countryInput.setText(user.getCountry());
       stateInput.setText(user.getState());
       postcodeInput.setText(user.getPostcode());
       telephoneInput.setText(user.getTelephoneNumber());
       emailInput.setText(user.getEmail());
    }
    
    @FXML
    private void onSave(final ActionEvent event) throws IOException
    {
        final User user = LoginController.getInstance().loggedUser;
        if(user == null)
            return;
        user.setFirstName(firstNameInput.getText());
        user.setMiddleName(middleNameInput.getText());
        user.setLastName(lastNameInput.getText());
        user.setGender(maleGenderInput.isSelected() ? 0 : 1);
        user.setDob(dobInput.getValue());
        user.setCountry(countryInput.getText());
        user.setState(stateInput.getText());
        user.setPostcode(postcodeInput.getText());
        user.setTelephoneNumber(telephoneInput.getText());
        user.setEmail(emailInput.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void onCancel(final ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void onRadioButton(final ActionEvent e)
    {
        final RadioButton button = (RadioButton) e.getSource();
        if(button.equals(maleGenderInput))
        {
            maleGenderInput.setSelected(true);
            femaleGenderInput.setSelected(false);
        } else
        if(button.equals(femaleGenderInput))
        {
            maleGenderInput.setSelected(false);
            femaleGenderInput.setSelected(true);
        }
    }
            
    
}

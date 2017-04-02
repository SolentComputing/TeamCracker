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
import org.ess.entity.Service;

/**
 *
 * @author Dean
 */
public class ViewServiceController implements Initializable {
    
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
        final Service service = MainController.getSelectedService();
        if(service == null)
            return;
        serviceNameInput.setText(service.getName());
        serviceDescInput.setText(service.getDescription());
        staffIDInput.setText(String.valueOf(service.getStaffId()));
        staffIDName.setText(service.getStaffName());
    }

    @FXML
    private void onSave(final ActionEvent event)
    {
        final Service service = MainController.getSelectedService();
        if(service == null)
            return;
        service.setName(serviceNameInput.getText())
               .setDescription(serviceDescInput.getText())
               .setStaffId(Integer.parseInt(staffIDInput.getText()));
        MainController.getController().updateTables();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void onCancel(final ActionEvent event)
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
}

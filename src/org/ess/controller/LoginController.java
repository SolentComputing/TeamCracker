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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Dean
 */
public class LoginController implements Initializable {

    @FXML
    private TextField userInput;
    @FXML
    private PasswordField passInput;
    @FXML
    private Label errorLabel;
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        
    }
    
    @FXML
    private void onLogin(final ActionEvent e)
    {
        final String username = userInput.getText();
        final String password = passInput.getText();
        if(!username.equals("user") || !password.equals("pass"))
        {
            errorLabel.setVisible(true);
            return;
        }
        errorLabel.setVisible(false);
        
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("/layout/main-page.fxml"));
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) userInput.getScene().getWindow();
            stage.setScene(scene);
            
        } catch(final IOException io) {
            
            io.printStackTrace();
            
        }
        
    }
    
}

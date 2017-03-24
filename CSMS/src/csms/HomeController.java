package csms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {

   public Button staffButton;
   public Button clientButton;
   public Button serviceButton;
 
   public void handleStaffButton() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("StaffFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) staffButton.getScene().getWindow();
        stage.setTitle("Staff");
        stage.setScene(scene);
   }
    
   public void handleClientsButton() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ClientFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) clientButton.getScene().getWindow();
        stage.setTitle("Clients");
        stage.setScene(scene);
   }
    
   public void handleServicesButton() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ServiceFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) serviceButton.getScene().getWindow();
        stage.setTitle("Services");
        stage.setScene(scene);
   }   
   
   
   
   
   
   
    
    
    
}

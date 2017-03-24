package csms;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Client {
    
    private final SimpleIntegerProperty clientId = new SimpleIntegerProperty();
    private final SimpleStringProperty clientFName = new SimpleStringProperty();
    private final SimpleStringProperty clientLName = new SimpleStringProperty();
    private final SimpleStringProperty clientEmail = new SimpleStringProperty();
    private final SimpleStringProperty clientAddress = new SimpleStringProperty();
    
    
    
    
    public Client(int clientIdIn, String clientFNameIn, String clientLNameIn, String clientEmailIn, String clientAddressIn){
        setClientId(clientIdIn);
        setClientFName(clientFNameIn);
        setClientLName(clientLNameIn);
        setClientEmail(clientEmailIn);        
        setClientAddress(clientAddressIn);        
        
    }
    
    public int getClientId() {
        return clientId.get();
    }
    public void setClientId(int clientId) {
        this.clientId.set(clientId);
    }
    
    public String getClientFName() {
        return clientFName.get();
    }
    
    public void setClientFName(String clientFNameIn) {
        clientFName.set(clientFNameIn);
    }
    
    public String getClientLName() {
        return clientLName.get();
    }
    
    public void setClientLName(String clientLNameIn) {
        clientLName.set(clientLNameIn);
    }
    
    public String getClientEmail() {
        return clientEmail.get();
    }
    
    
    public void setClientEmail(String clientEmailIn){
        clientEmail.set(clientEmailIn);
        
    }
    
    public String getClientAddress() {
        return clientAddress.get();
    }
    
    
    public void setClientAddress(String clientAddressIn){
        clientAddress.set(clientAddressIn);
        
    }
    
    public void displayClient(){
        System.out.println("Client ID: " + clientId + "Client first name: " + clientFName + "Client last name: " + clientLName + "Client email: " + clientEmail + "Client address: " + clientAddress);
        
        
    }
    
    
    
    
}
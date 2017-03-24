package csms;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Services {
    
    private final SimpleIntegerProperty serviceId = new SimpleIntegerProperty();
    private final SimpleStringProperty serviceType = new SimpleStringProperty();
    private final SimpleStringProperty serviceDesc = new SimpleStringProperty();
    
    
    
    public Services(int serviceIdIn, String serviceTypeIn, String serviceDescIn){
        setServiceId(serviceIdIn);
        setServiceType(serviceTypeIn);
        setServiceDesc(serviceDescIn);
        
    }
    
    public int getServiceId() {
        return serviceId.get();
    }
    public void setServiceId(int serviceId) {
        this.serviceId.set(serviceId);
    }
    
    public String getServiceType() {
        return serviceType.get();
    }
    
    public void setServiceType(String serviceTypeIn) {
        serviceType.set(serviceTypeIn);
    }
    
    public String getServiceDesc() {
        return serviceDesc.get();
    }
    
    public void setServiceDesc(String serviceDescIn) {
        serviceDesc.set(serviceDescIn);
    }   
    
    
    public void displayClient(){
        System.out.println("Service ID: " + serviceId + "Service type: " + serviceType + "Service Description: " + serviceDesc);
    }   
    
    
}
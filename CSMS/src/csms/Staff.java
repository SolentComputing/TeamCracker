package csms;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Staff {
    
    private final SimpleIntegerProperty staffId = new SimpleIntegerProperty();
    private final SimpleStringProperty staffFName = new SimpleStringProperty();
    private final SimpleStringProperty staffLName = new SimpleStringProperty();
    private final SimpleStringProperty staffDob = new SimpleStringProperty();
    private final SimpleStringProperty staffEmail = new SimpleStringProperty();
    private final SimpleStringProperty staffAvailability = new SimpleStringProperty();
    private final SimpleStringProperty staffRole = new SimpleStringProperty();
    private final SimpleStringProperty staffAddress = new SimpleStringProperty();
    
    
    
    
    public Staff(int staffId, String staffFNameIn, String staffLNameIn, String staffDobIn, String staffEmailIn, String staffAvailabilityIn, String staffRoleIn, String staffAddressIn){
        setStaffId(staffId);
        setStaffFName(staffFNameIn);
        setStaffLName(staffLNameIn);
        setStaffDob(staffDobIn);
        setStaffEmail(staffEmailIn);
        setStaffAvailability(staffAvailabilityIn);
        setStaffRole(staffRoleIn);
        setStaffAddress(staffAddressIn);
        
        
    }
    
    public int getStaffId() {
        return staffId.get();
    }
    public void setStaffId(int staffId) {
        this.staffId.set(staffId);
    }
    
    public String getStaffFName() {
        return staffFName.get();
    }
    
    public void setStaffFName(String staffFNameIn) {
        staffFName.set(staffFNameIn);
    }
    
    public String getStaffLName() {
        return staffLName.get();
    }
    
    public void setStaffLName(String staffLNameIn) {
        staffLName.set(staffLNameIn);
    }
    
    public String getStaffFDob() {
        return staffDob.get();
    }
    
    public void setStaffDob(String staffDobIn) {
        staffDob.set(staffDobIn);
    }
    public String getStaffEmail() {
        return staffEmail.get();
    }
    
    public void setStaffEmail(String staffEmailIn) {
        staffEmail.set(staffEmailIn);
    }
    public String getStaffRole() {
        return staffRole.get();
    }
    
    public void setStaffRole(String staffRoleIn) {
        staffRole.set(staffRoleIn);
    }
    
    public String getStaffAvailability() {
        return staffAvailability.get();
    }
    
    public void setStaffAvailability(String staffAvailabilityIn) {
        staffAvailability.set(staffAvailabilityIn);
    }
    
    public String getStaffAddress() {
        return staffAddress.get();
    }
    
    public void setStaffAddress(String staffAddressIn) {
        staffAddress.set(staffAddressIn);
    }
    
    public void displayClient(){
        System.out.println("Staff ID: " + staffId + "Staff first name: " + staffFName + "Staff last name: " + staffLName + "Staff date of birth: " + staffDob + "Staff email: " + staffEmail + "Staff availability: " + staffAvailability + "Staff role: " + staffRole + "Staff address: " + staffAddress);
    }   
    
}
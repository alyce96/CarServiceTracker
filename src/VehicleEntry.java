///Alyce Cooper
/// //May7th 2025
/// Project week 4
/// 



public class VehicleEntry{
    private String status;
    private String customerName;
    private String phoneNumber;
    private String vehicleDescription;

    //Constructor Function 
    public VehicleEntry(String customerName, String phoneNumber, String vehicleDescription) {
        this.status = "Not Started";
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.vehicleDescription = vehicleDescription;
    }

    //Methods 

    public void updateStatus(String newStatus){ //new status should be "in progress" or "complete"
        if (newStatus == "In Progress" || newStatus== "Complete") {
            this.status = newStatus;
            System.out.println("Status of vehicle '" + this.vehicleDescription + "' updated to: "+ this.status);
        } 
        else{
            System.out.println("invaild status");
        }
    }
    
    //to string function
    @Override
    public String toString(){
        return "Customer: " + customerName + 
        "\nPhone: " + phoneNumber + 
        "\nVehicle: " + vehicleDescription +
        "\nStatus: " + status;
    }

    //Getters 
    public String getCustomerName(){
        return customerName;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getVehicleDescription(){
        return vehicleDescription;
    }
    public String getStatus(){
        return status;
    }
}
///Alyce Cooper
/// //May4th 2025
/// Project week 3 

//SERVICE INFORMATION

//ID of the service
//CustomerName
//Phone number of customer
//Vehicle Description
//Status
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ServiceTracker {
    //Class variable arraylist to hold entry
    private List<VehicleEntry> vehicleList;

    //constructor function 
    public ServiceTracker() {
        this.vehicleList = new ArrayList<>();
    }

    

    //AddEntry Function
    //Gather data from the passed Vehicle Entry
    public void addEntry(VehicleEntry vehicleinfo) {
        if (vehicleinfo != null) {
            this.vehicleList.add(vehicleinfo);
            System.out.println("Added Entry for: " + vehicleinfo.getCustomerName());
        }
        else {
            System.out.println("Can not add a null info");
        }
    }

    //RemoveEntry
    public void removeEntry(String vehicleDescription, String phoneNumber) {
        boolean removed = false;
        Iterator<VehicleEntry> iterator = this.vehicleList.iterator();
        while (iterator.hasNext()) {
            VehicleEntry entry = iterator.next();
            if (entry.getPhoneNumber().equalsIgnoreCase(phoneNumber) && entry.getVehicleDescription().equalsIgnoreCase(vehicleDescription)){
                iterator.remove();
                System.out.println("Removed entry for: " + phoneNumber + " - " + vehicleDescription);
                removed = true; 
            }

        } if(!removed) {
            System.out.println("Could not find entry to remove for: " + phoneNumber + " - " + vehicleDescription);
        }
    }

    public List<VehicleEntry> searchByName(String customerName) {
        List<VehicleEntry> results = new ArrayList<>();
        for (VehicleEntry entry : this.vehicleList) {
            if (entry.getCustomerName().equalsIgnoreCase(customerName)) {
                results.add(entry);
            }
        }
        System.out.println("Found "+ results.size() + " entries for name:  " + customerName);
        return results;
    }

    public List<VehicleEntry> searchByPhone(String phoneNumber) {
        List<VehicleEntry> results = new ArrayList<>();
        for (VehicleEntry entry : this.vehicleList) {
            if (entry.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                results.add(entry);
            }
        }
        System.out.println("Found "+ results.size() + " entries for phoneNumber:  " + phoneNumber);
        return results;
    }
}

///Alyce Cooper
/// //May4th 2025
/// Project week 4


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceTrackerDB {

    public static Connection connect(String dbFile){
        String url = "jdbc:sqlite:" + dbFile;
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        }
        catch(SQLException e) { 
            System.err.println("dbConnectionError: " + e.getMessage());

        }
        return conn;
    }
    public static boolean addEntry(Connection conn, VehicleEntry entry) {
        String sql = "INSERT INTO Vehicle(customerName, phoneNumber, vehicleDescription, status) VALUES(?,?,?,?)";
        try(PreparedStatement prpstmt = conn.prepareStatement(sql)) {
            prpstmt.setString(1, entry.getCustomerName());
            prpstmt.setString(2, entry.getPhoneNumber());
            prpstmt.setString(3, entry.getVehicleDescription());
            prpstmt.setString(4, entry.getStatus());

            int rows = prpstmt.executeUpdate();
            return rows > 0;



        } catch (SQLException e){
            System.err.println("error adding vehicle entry: " + e.getMessage());
            return false;
        }
    }
    public static boolean createVehicleTable(Connection conn) {
        return true;
    }
    public static boolean updateStatus(Connection conn, String phoneNumber, String vehicleDescription, String newStatus){
        return true;
    }
    public static boolean removeEntry(Connection conn, String phoneNumber, String vehicleDescription){
        return true;
    }
    public static VehicleEntry getEntryByKey(Connection conn, String phoneNumber, String vehicleDescription) {
        VehicleEntry entry = null;
        return entry;
    }
    public static List<VehicleEntry> searchByName(Connection conn, String customerName) {
        List<VehicleEntry> results = new ArrayList<>();
        String sql = "SELECT customerName, phoneNumber, status FROM Vehicles WHERE customerName LIKE ? COLLATE NOCASE";
        try (Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql)) {
                while(rs.next()) {
                    VehicleEntry entry = new VehicleEntry(rs.getString("customerName"), rs.getString("phoneNumber"), rs.getString("vehicleDescription", rs.getString("status")));
                        results.add(entry);
                } 
                
        } catch(SQLException e) {
            System.out.println("Error retreiving Vehicle Entries: " + e.getMessage());
        } 
        return results;
    }
    public static List<VehicleEntry> searchByPhoneNumber(Connection conn, String phoneNumber) {
        List<VehicleEntry> results = new ArrayList<>();
        String sql = "SELECT customerName, phoneNumber, status FROM Vehicles WHERE phoneNumber = ?";
        try (Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql)) {
                while(rs.next()) {
                    VehicleEntry entry = new VehicleEntry(rs.getString("customerName"), rs.getString("phoneNumber"), rs.getString("vehicleDescription", rs.getString("status")));
                        results.add(entry);
                } 
                
        } catch(SQLException e) {
            System.out.println("Error retreiving Vehicle Entries: " + e.getMessage());
        } 
        return results;
    }
    public static List<VehicleEntry> getAllEntries(Connection conn) {
        List<VehicleEntry> results = new ArrayList<>();
        String sql = "SELECT customerName, phoneNumber, status FROM Vehicles";
        try (Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql)) {
                while(rs.next()) {
                    VehicleEntry entry = new VehicleEntry(rs.getString("customerName"), rs.getString("phoneNumber"), rs.getString("vehicleDescription", rs.getString("status")));
                        results.add(entry);
                } 
                
        } catch(SQLException e) {
            System.out.println("Error retreiving Vehicle Entries: " + e.getMessage());
        } 
        return results;
    }
    //Add Entry
        //Insert INTO Vehicle VALUES (?, ?, ?,)

    
}





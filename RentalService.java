import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void showAvailableVehicles() {
        System.out.println("\nAvailable Vehicles:");
        boolean found = false;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                vehicle.displayDetails(); // polymorphic behavior
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles available.");
        }
    }

    public Vehicle findVehicleById(String id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equalsIgnoreCase(id)) {
                return vehicle;
            }
        }
        return null;
    }

    public void rentVehicle(String id, Customer customer, int days) {
        Vehicle vehicle = findVehicleById(id);

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        if (!vehicle.isAvailable()) {
            System.out.println("Vehicle is already rented.");
            return;
        }

        vehicle.setAvailable(false);
        double cost = vehicle.calculateRentalCost(days); // runtime polymorphism

        System.out.println("\nRental Successful!");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Vehicle: " + vehicle.getBrand() +
                " (" + vehicle.getClass().getSimpleName() + ")");
        System.out.println("Days: " + days);
        System.out.println("Total Cost: ₹" + cost);
    }

    public void returnVehicle(String id) {
        Vehicle vehicle = findVehicleById(id);

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        if (vehicle.isAvailable()) {
            System.out.println("Vehicle is already available.");
            return;
        }

        vehicle.setAvailable(true);
        System.out.println("Vehicle returned successfully.");
    }
}
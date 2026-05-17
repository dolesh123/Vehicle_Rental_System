import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalService rentalService = new RentalService();

        // Seed data
        rentalService.addVehicle(new Car("C101", "Toyota Innova", 2500));
        rentalService.addVehicle(new Car("C102", "Honda City", 2200));
        rentalService.addVehicle(new Bike("B201", "Royal Enfield", 900));
        rentalService.addVehicle(new Bike("B202", "Yamaha R15", 800));

        while (true) {
            System.out.println("\n===== VEHICLE RENTAL SYSTEM =====");
            System.out.println("1. Show Available Vehicles");
            System.out.println("2. Rent Vehicle");
            System.out.println("3. Return Vehicle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    rentalService.showAvailableVehicles();
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
                    Customer customer = new Customer(customerName);

                    System.out.print("Enter Vehicle ID: ");
                    String vehicleId = scanner.nextLine();

                    System.out.print("Enter Number of Days: ");
                    int days = scanner.nextInt();
                    scanner.nextLine();

                    rentalService.rentVehicle(vehicleId, customer, days);
                    break;

                case 3:
                    System.out.print("Enter Vehicle ID to return: ");
                    String returnId = scanner.nextLine();
                    rentalService.returnVehicle(returnId);
                    break;

                case 4:
                    System.out.println("Thank you for using Vehicle Rental System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
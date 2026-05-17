public abstract class Vehicle {
    private String id;
    private String brand;
    private double ratePerDay;
    private boolean available;

    public Vehicle(String id, String brand, double ratePerDay) {
        this.id = id;
        this.brand = brand;
        this.ratePerDay = ratePerDay;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public double getRatePerDay() {
        return ratePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Runtime polymorphism
    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("ID: " + id +
                ", Brand: " + brand +
                ", Type: " + getClass().getSimpleName() +
                ", Rate/Day: ₹" + ratePerDay +
                ", Available: " + available);
    }
}
public class Bike extends Vehicle {

    public Bike(String id, String brand, double ratePerDay) {
        super(id, brand, ratePerDay);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Flat pricing for bikes
        return getRatePerDay() * days;
    }
}
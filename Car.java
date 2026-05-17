public class Car extends Vehicle {

    public Car(String id, String brand, double ratePerDay) {
        super(id, brand, ratePerDay);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Cars get 10% discount for rentals longer than 7 days
        double total = getRatePerDay() * days;
        if (days > 7) {
            total *= 0.90;
        }
        return total;
    }
}
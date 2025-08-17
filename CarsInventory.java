import java.util.*;

public class CarsInventory {
    private HashMap<String, ArrayList<Car>> inventory = new HashMap<>();

    // Add car to inventory
    public void addCar(Car car) {
        inventory.putIfAbsent(car.getMake(), new ArrayList<>());
        inventory.get(car.getMake()).add(car);
    }

    // Remove car by VIN
    public void removeCar(String vin) {
        for (ArrayList<Car> cars : inventory.values()) {
            cars.removeIf(c -> c.getVin().equals(vin));
        }
    }

    // Get all cars by make
    public List<Car> getCarsByMake(String make) {
        return inventory.getOrDefault(make, new ArrayList<>());
    }

    // --- NEW HELPERS ---

    // Collect all cars into one list
    private List<Car> getAllCars() {
        List<Car> allCars = new ArrayList<>();
        for (ArrayList<Car> cars : inventory.values()) {
            allCars.addAll(cars);
        }
        return allCars;
    }

    // Search cars cheaper than price
    public List<Car> getCarsCheaperThan(double price) {
        List<Car> results = new ArrayList<>();
        for (Car car : getAllCars()) {
            if (car.getPrice() <= price) {
                results.add(car);
            }
        }
        return results;
    }

    // Search cars within price range
    public List<Car> getCarsInPriceRange(double min, double max) {
        List<Car> results = new ArrayList<>();
        for (Car car : getAllCars()) {
            if (car.getPrice() >= min && car.getPrice() <= max) {
                results.add(car);
            }
        }
        return results;
    }

    // Search cars newer than a given year
    public List<Car> getCarsNewerThan(int year) {
        List<Car> results = new ArrayList<>();
        for (Car car : getAllCars()) {
            if (car.getYear() > year) {
                results.add(car);
            }
        }
        return results;
    }

    // Show entire inventory
    public void showInventory() {
        for (String make : inventory.keySet()) {
            System.out.println(make + ":");
            for (Car car : inventory.get(make)) {
                System.out.println("   " + car);
            }
        }
    }
}


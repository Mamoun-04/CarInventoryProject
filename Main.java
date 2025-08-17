public class Main {
    public static void main(String[] args) {
        CarsInventory inventory = new CarsInventory();

        // Add some cars
        Car car1 = new Car("VIN123", "BMW", "M3", 2020, 65000);
        Car car2 = new Car("VIN124", "BMW", "M4", 2021, 72000);
        Car car3 = new Car("VIN125", "Mercedes", "C63", 2019, 68000);
        Car car4 = new Car("VIN126", "Audi", "RS7", 2022, 95000);

        inventory.addCar(car1);
        inventory.addCar(car2);
        inventory.addCar(car3);
        inventory.addCar(car4);

        System.out.println("Initial inventory:");
        inventory.showInventory();

        System.out.println("\nCars cheaper than 70,000:");
        for (Car c : inventory.getCarsCheaperThan(70000)) {
            System.out.println(c);
        }

        System.out.println("\nCars between 65,000 and 75,000:");
        for (Car c : inventory.getCarsInPriceRange(65000, 75000)) {
            System.out.println(c);
        }

        System.out.println("\nCars newer than 2020:");
        for (Car c : inventory.getCarsNewerThan(2020)) {
            System.out.println(c);
        }

        // Remove a car
        inventory.removeCar("VIN124");
        System.out.println("\nAfter removing VIN124:");
        inventory.showInventory();
    }
}

public class Car {
    private String vin;   // unique id
    private String make;  // e.g. BMW
    private String model; // e.g. M3
    private int year;
    private double price;

    public Car(String vin, String make, String model, int year, double price) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getVin() { return vin; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return year + " " + make + " " + model + " ($" + price + ")";
    }
}

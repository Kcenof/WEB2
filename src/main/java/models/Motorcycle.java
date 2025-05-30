package models;

public class Motorcycle extends Vehicle {
    private int engineCapacity;

    public Motorcycle() {}

    public Motorcycle(String make, String model, int engineCapacity) {
        super(make, model);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() { return engineCapacity; }
    public void setEngineCapacity(int engineCapacity) { this.engineCapacity = engineCapacity; }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", Обʼєм двигуна: " + engineCapacity + " см³";
    }
}

package services;

import models.Motorcycle;

public class VehicleService {
    private Motorcycle motorcycle = new Motorcycle("Yamaha", "MT-07", 689);

    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }
}

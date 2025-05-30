package services;

import models.*;

public class ApplianceService {
    public String activate(Appliance appliance) {
        return appliance.turnOn();
    }
}


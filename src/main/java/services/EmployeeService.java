package services;

import models.Manager;

public class EmployeeService {
    private Manager manager = new Manager("Іван", "Менеджер", 5);

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}

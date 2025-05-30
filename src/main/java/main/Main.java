import models.*;
import interfaces.*;
import services.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Інкапсуляція — Завдання 1 ---");
        Book book = new Book("Тіні забутих предків", "Михайло Коцюбинський", 1911);
        book.displayInfo();

        System.out.println("\n--- Інкапсуляція — Завдання 2 ---");
        System.out.println("\nОновлюємо назву...");
        book.setTitle("Тіні забутих предків (оновлено)");
        book.displayInfo();

        Account acc = new Account("UA123456789", 1000.0);
        System.out.println("Баланс рахунку " + acc.getAccountNumber() + ": " + acc.getBalance() + " грн");
        acc.deposit(500.0);
        System.out.println("Поповнено: 500.0 грн");
        acc.withdraw(300.0);
        System.out.println("Знято: 300.0 грн");
        acc.withdraw(2000.0);
        System.out.println("Недостатньо коштів або некоректна сума");
        System.out.println("Баланс рахунку " + acc.getAccountNumber() + ": " + acc.getBalance() + " грн");

        System.out.println("\n--- Наслідування — Завдання 1 ---");
        Motorcycle mc = new Motorcycle("Yamaha", "MT-07", 689);
        System.out.println(mc.displayInfo());

        System.out.println("\n--- Наслідування — Завдання 2 ---");
        Manager manager = new Manager("Олена Іваненко", "Менеджер проектів", 5);
        System.out.println(manager.displayInfo());

        System.out.println("\n--- Поліморфізм — Завдання 1 ---");
        Shape triangle = new Triangle(10, 5);
        Shape square = new Square(4);
        System.out.println("Площа трикутника: " + triangle.calculateArea());
        System.out.println("Площа квадрата: " + square.calculateArea());

        System.out.println("\n--- Поліморфізм — Завдання 2 ---");
        Notification email = new EmailNotification("user@example.com", "Привіт!");
        Notification sms = new SMSNotification("+380123456789", "Код: 1234");
        System.out.println(email.send());
        System.out.println(sms.send());

        System.out.println("\n--- Абстрактні класи — Завдання 1 ---");
        Appliance wm = new WashingMachine();
        Appliance mw = new Microwave();
        System.out.println(wm.turnOn());
        System.out.println(mw.turnOn());

        System.out.println("\n--- Інтерфейси — Завдання 2 ---");
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        System.out.println(guitar.play());
        System.out.println(piano.play());
    }
}

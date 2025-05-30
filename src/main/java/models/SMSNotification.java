package models;

public class SMSNotification extends Notification {

    public SMSNotification() {}

    public SMSNotification(String recipient, String message) {
        super(recipient, message);
    }

    @Override
    public String send() {
        return "SMS до " + recipient + ": " + message;
    }
}

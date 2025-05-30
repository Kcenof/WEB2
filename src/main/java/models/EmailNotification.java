package models;

public class EmailNotification extends Notification {

    public EmailNotification() {}

    public EmailNotification(String recipient, String message) {
        super(recipient, message);
    }

    @Override
    public String send() {
        return "Email до " + recipient + ": " + message;
    }
}

package models;

public class Notification {
    protected String recipient;
    protected String message;

    public Notification() {}

    public Notification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    public String getRecipient() { return recipient; }
    public String getMessage() { return message; }

    public void setRecipient(String recipient) { this.recipient = recipient; }
    public void setMessage(String message) { this.message = message; }

    public String send() {
        return "Відправка повідомлення до " + recipient;
    }
}

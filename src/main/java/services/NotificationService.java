package services;

import models.*;

public class NotificationService {

    public String sendNotification(Notification notification) {
        return notification.send();
    }
}

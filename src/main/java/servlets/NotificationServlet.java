package servlets;

import com.google.gson.Gson;
import models.*;
import services.NotificationService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/notification")
public class NotificationServlet extends HttpServlet {
    private NotificationService notificationService;
    private Gson gson;

    @Override
    public void init() {
        notificationService = new NotificationService();
        gson = new Gson();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        NotificationRequest request = gson.fromJson(req.getReader(), NotificationRequest.class);
        Notification notification = null;

        if ("email".equalsIgnoreCase(request.type)) {
            notification = new EmailNotification(request.recipient, request.message);
        } else if ("sms".equalsIgnoreCase(request.type)) {
            notification = new SMSNotification(request.recipient, request.message);
        }

        String result = notificationService.sendNotification(notification);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"result\":\"" + result + "\"}");
    }

    private static class NotificationRequest {
        String type;
        String recipient;
        String message;
    }
}

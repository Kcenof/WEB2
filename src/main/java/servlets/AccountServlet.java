package servlets;

import com.google.gson.Gson;
import models.Account;
import services.AccountService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    private AccountService accountService;
    private Gson gson;

    @Override
    public void init() {
        accountService = new AccountService();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Account acc = accountService.getAccount();
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(acc));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OperationRequest op = gson.fromJson(req.getReader(), OperationRequest.class);
        boolean success = false;
        String message;

        if ("deposit".equalsIgnoreCase(op.type)) {
            accountService.deposit(op.amount);
            message = "Кошти поповнено";
            success = true;
        } else if ("withdraw".equalsIgnoreCase(op.type)) {
            success = accountService.withdraw(op.amount);
            message = success ? "Кошти знято" : "Недостатньо коштів";
        } else {
            message = "Невідома операція";
        }

        resp.setContentType("application/json");
        resp.getWriter().write("{\"success\":" + success + ",\"message\":\"" + message + "\"}");
    }

    private static class OperationRequest {
        String type;
        double amount;
    }
}

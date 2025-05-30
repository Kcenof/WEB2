package servlets;

import com.google.gson.Gson;
import models.Manager;
import services.EmployeeService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/manager")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;
    private Gson gson;

    @Override
    public void init() {
        employeeService = new EmployeeService();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Manager manager = employeeService.getManager();
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(manager));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Manager manager = gson.fromJson(req.getReader(), Manager.class);
        employeeService.setManager(manager);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"message\":\"Менеджера оновлено\"}");
    }
}

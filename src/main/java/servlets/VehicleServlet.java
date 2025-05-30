package servlets;

import com.google.gson.Gson;
import models.Motorcycle;
import services.VehicleService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/motorcycle")
public class VehicleServlet extends HttpServlet {
    private VehicleService vehicleService;
    private Gson gson;

    @Override
    public void init() {
        vehicleService = new VehicleService();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Motorcycle mc = vehicleService.getMotorcycle();
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(mc));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Motorcycle mc = gson.fromJson(req.getReader(), Motorcycle.class);
        vehicleService.setMotorcycle(mc);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"message\":\"Мотоцикл оновлено\"}");
    }
}

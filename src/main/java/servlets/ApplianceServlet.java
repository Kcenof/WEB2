package servlets;

import com.google.gson.Gson;
import models.*;
import services.ApplianceService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/appliance")
public class ApplianceServlet extends HttpServlet {
    private ApplianceService applianceService;
    private Gson gson;

    @Override
    public void init() {
        applianceService = new ApplianceService();
        gson = new Gson();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ApplianceRequest request = gson.fromJson(req.getReader(), ApplianceRequest.class);
        Appliance appliance = null;

        if ("microwave".equalsIgnoreCase(request.type)) {
            appliance = new Microwave();
        } else if ("washingMachine".equalsIgnoreCase(request.type)) {
            appliance = new WashingMachine();
        }

        String result = applianceService.activate(appliance);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"result\":\"" + result + "\"}");
    }

    private static class ApplianceRequest {
        String type;
    }
}

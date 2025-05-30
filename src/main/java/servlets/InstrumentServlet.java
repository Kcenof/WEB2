package servlets;

import com.google.gson.Gson;
import interfaces.Playable;
import models.*;
import services.InstrumentService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/instrument")
public class InstrumentServlet extends HttpServlet {
    private InstrumentService instrumentService;
    private Gson gson;

    @Override
    public void init() {
        instrumentService = new InstrumentService();
        gson = new Gson();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        InstrumentRequest request = gson.fromJson(req.getReader(), InstrumentRequest.class);
        Playable instrument = null;

        if ("guitar".equalsIgnoreCase(request.type)) {
            instrument = new Guitar();
        } else if ("piano".equalsIgnoreCase(request.type)) {
            instrument = new Piano();
        }

        String result = instrumentService.perform(instrument);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"result\":\"" + result + "\"}");
    }

    private static class InstrumentRequest {
        String type;
    }
}

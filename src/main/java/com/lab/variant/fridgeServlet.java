package com.lab.variant;

import com.google.gson.Gson;
import com.lab.variant.service.fridgeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;

@WebServlet("/fridge")
public class fridgeServlet extends HttpServlet {
    private fridgeService service = new fridgeService();
    private Gson gson = new Gson();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = gson.toJson(service.getAll());
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        fridge f = gson.fromJson(req.getReader(), fridge.class);
        service.add(f);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        fridge f = gson.fromJson(req.getReader(), fridge.class);
        service.update(f);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}

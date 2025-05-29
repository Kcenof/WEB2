package com.lab.variant;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import java.io.IOException;

@WebServlet("/fridge")
public class fridgeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        fridge fridge  = new fridge("Великий холодильник", "images/me.jpg", "Холодильник для зберiгання харчiв", 500.0, "Нержавіюча сталь");
        Gson gson = new Gson();
        String json = gson.toJson(fridge);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}
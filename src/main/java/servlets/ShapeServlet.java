package servlets;

import com.google.gson.Gson;
import models.Shape;
import models.Square;
import models.Triangle;
import services.ShapeService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/shape")
public class ShapeServlet extends HttpServlet {
    private ShapeService shapeService;
    private Gson gson;

    @Override
    public void init() {
        shapeService = new ShapeService();
        gson = new Gson();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        ShapeRequest request = gson.fromJson(reader, ShapeRequest.class);

        Shape shape = null;

        if ("triangle".equalsIgnoreCase(request.type)) {
            shape = new Triangle(request.base, request.height);
        } else if ("square".equalsIgnoreCase(request.type)) {
            shape = new Square(request.side);
        }

        double area = shapeService.calculateArea(shape);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"area\":" + area + "}");
    }

    private static class ShapeRequest {
        String type;
        double base;
        double height;
        double side;
    }
}

package servlets;

import com.google.gson.Gson;
import models.Book;
import services.BookService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private BookService bookService;
    private Gson gson;

    @Override
    public void init() {
        bookService = new BookService();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(bookService.getBook()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Book book = gson.fromJson(req.getReader(), Book.class);
        bookService.saveBook(book);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
